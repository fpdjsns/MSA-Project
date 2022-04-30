package com.withhamit.circuit.presentation.router

import com.withhamit.circuit.presentation.handler.*
import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*

@Configuration
class MemberRouter(private val handler: MemberHandler) {

    @Bean
    fun testRoute() = router {
        "/members".nest {
            GET("/{memberNo}", handler::getMember)
        }
    }
}
