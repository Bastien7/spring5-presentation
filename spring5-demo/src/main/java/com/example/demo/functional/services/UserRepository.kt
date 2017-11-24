package com.example.demo.functional.services

import com.example.demo.model.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

class UserRepository {
    private val users = arrayOf(User("Joe", 28), User("Marc", 34))

    fun findOneUser(name: String): Mono<User> = users.find { it.name == name }?.toMono() ?: Mono.empty()
    fun findAllUsers(): Flux<User> = users.toFlux()
}