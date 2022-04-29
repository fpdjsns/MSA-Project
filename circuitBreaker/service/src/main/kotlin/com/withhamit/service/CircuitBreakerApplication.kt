package com.withhamit.service

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*

@SpringBootApplication
class CircuitBreakerApplication

fun main(args: Array<String>) {
    runApplication<CircuitBreakerApplication>(*args)
}
