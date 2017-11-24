package com.example.demo.functional.configuration

import com.example.demo.functional.services.RouteHandler
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

fun router(userService: RouteHandler) = router {

    accept(MediaType.ALL).nest {
        GET("/") { ok().body("Hello".toMono()) }
        GET("/user", userService::findOneUser)
        GET("/users") { userService.findAllUsers() }
    }
}
