package com.withhamit.service.presentation.router

import com.withhamit.service.presentation.handler.*
import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*

@Configuration
class TestRouter(private val handler: TestHandler) {

    @Bean
    fun testRoute() = router {
        "/test".nest {
            GET("", handler::test)
        }
    }
}
