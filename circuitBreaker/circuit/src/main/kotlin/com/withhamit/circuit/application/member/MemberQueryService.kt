package com.withhamit.circuit.application.member

import org.springframework.stereotype.*
import reactor.core.publisher.*
import java.time.*

@Service
class MemberQueryService(
    private val memberExternalQueryService: MemberExternalQueryService
) {
    fun getMember(no: Int, delay: Long = 0L): Mono<MemberModel> {
        return Mono.just(memberExternalQueryService.getMember(no))
            .delayElement(Duration.ofMillis(delay))
    }
}
