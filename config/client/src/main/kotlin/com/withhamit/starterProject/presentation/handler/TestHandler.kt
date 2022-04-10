package com.withhamit.starterProject.presentation.handler

import com.withhamit.starterProject.infra.properties.*
import org.springframework.beans.factory.annotation.*
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Mono

@Configuration
class TestHandler(
    private val testProperties: TestProperties
) {

    fun test(request: ServerRequest): Mono<ServerResponse> {
        return ok().bodyValue(testProperties.message)
    }
}
