package com.withhamit.circuit.presentation.handler

import com.withhamit.circuit.application.member.*
import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.*

@Configuration
class MemberHandler(
    private val memberQueryService: MemberQueryService
) {

    fun getMember(request: ServerRequest): Mono<ServerResponse> {
        val memberNo = request.pathVariable("memberNo")?.toIntOrNull() ?: 0
        val delay = request.queryParamOrNull("delay")?.toLongOrNull() ?: 0
        return ok().bodyValue(memberQueryService.getMember(memberNo, delay))
    }
}
