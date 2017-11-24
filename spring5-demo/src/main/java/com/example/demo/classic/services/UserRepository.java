package com.example.demo.classic.services;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private static List<User> users = Arrays.asList(new User("Joe", 28), new User("Marc", 34));

    public Mono<User> findOneUser(String name) {
        Optional<User> userFound = users.stream().filter(user -> user.getName().equals(name)).findFirst();
        return Mono.justOrEmpty(userFound);
    }

    public Flux<User> findAllUsers() {
        User[] array = (User[]) users.toArray();
        return Flux.fromArray(array);
    }
}
