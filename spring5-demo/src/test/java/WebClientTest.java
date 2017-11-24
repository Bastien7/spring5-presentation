import com.example.demo.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

public class WebClientTest {
    private static WebClient webClient;

    @BeforeClass
    public static void prepareWebClient() {
        webClient = WebClient.create("http://localhost:8080");
    }

    @Test
    public void getUser() {
        User user = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/user").queryParam("name", "Joe").build())
                .exchange()
                .block()
                .bodyToMono(User.class)
                .block();

        System.out.println(user.getName());
    }
    @Test
    public void getUsers() {
        User[] users = webClient.
                get()
                .uri("/users")
                .exchange()
                .block()
                .bodyToMono(User[].class)
                .block();

        for (User user: users) {
            System.out.println(user.getName());
        }
    }
}
