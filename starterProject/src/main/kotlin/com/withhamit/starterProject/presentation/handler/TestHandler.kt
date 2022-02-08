package com.withhamit.starterProject.presentation.handler

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Mono

@Configuration
class TestHandler {
    fun test(request: ServerRequest): Mono<ServerResponse> {
        val msg = request.queryParamOrNull("msg") ?: ""
        return ok().bodyValue(msg)
    }
}