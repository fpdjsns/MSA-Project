package com.withhamit.circuit.presentation.router

import com.withhamit.circuit.presentation.handler.TestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class TestRouter(private val handler: TestHandler) {

    @Bean
    fun testRoute() = router {
        "/test".nest {
            GET("", handler::test)
        }
    }
}
