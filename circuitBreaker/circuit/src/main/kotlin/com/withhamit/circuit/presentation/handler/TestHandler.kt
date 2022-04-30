package com.withhamit.circuit.presentation.handler

import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.*
import java.time.*

@Configuration
class TestHandler {

    fun test(request: ServerRequest): Mono<ServerResponse> {
        val delay = request.queryParamOrNull("delay")?.toLongOrNull() ?: 0
        return ok().bodyValue("ok").delayElement(Duration.ofMillis(delay))
    }
}
