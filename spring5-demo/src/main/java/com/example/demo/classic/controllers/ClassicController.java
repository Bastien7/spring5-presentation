package com.example.demo.classic.controllers;

import com.example.demo.classic.services.UserRepository;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClassicController {

    private final UserRepository userRepository;

    public ClassicController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public Mono<String> hello() {
        return Mono.just("Hello");
    }

    @GetMapping("/user")
    public Mono<User> findUser(@RequestParam("name") String name) {
        return userRepository.findOneUser(name);
    }

    @GetMapping("/users")
    public Flux<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
