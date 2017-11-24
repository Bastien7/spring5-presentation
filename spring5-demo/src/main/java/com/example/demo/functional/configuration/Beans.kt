package com.example.demo.functional.configuration

import com.example.demo.functional.services.UserRepository
import com.example.demo.functional.services.RouteHandler
import org.springframework.context.support.beans


fun beans() = beans {
    bean<UserRepository>()
    bean { RouteHandler(ref()) }
    bean { router(ref()) }
}


/*
fun beans() = beans {
    val userRepository = UserRepository()
    val routeHandler = RouteHandler(userRepository)
    val router = router(routeHandler)

    bean<UserRepository>()
    bean { routeHandler }
    bean { router }
}
*/