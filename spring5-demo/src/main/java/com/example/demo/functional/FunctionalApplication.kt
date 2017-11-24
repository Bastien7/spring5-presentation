package com.example.demo.functional

import com.example.demo.functional.configuration.beans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {
        addInitializers(beans())
    }
}