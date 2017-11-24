package com.example.demo.functional.services

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body

class RouteHandler(val userRepository: UserRepository) {

    fun findOneUser(request: ServerRequest) = ok().body(userRepository.findOneUser(request.queryParam("name").get()))

    fun findAllUsers() = ok().body(userRepository.findAllUsers())
}
