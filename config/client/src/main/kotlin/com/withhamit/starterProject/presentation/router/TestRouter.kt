package com.withhamit.starterProject.presentation.router

import com.withhamit.starterProject.presentation.handler.TestHandler
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