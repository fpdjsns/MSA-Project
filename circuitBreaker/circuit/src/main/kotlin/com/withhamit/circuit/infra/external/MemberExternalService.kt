package com.withhamit.circuit.infra.external

import com.withhamit.circuit.application.member.*
import io.github.resilience4j.circuitbreaker.*
import io.vavr.*
import io.vavr.control.*
import org.springframework.stereotype.*

@Service
class MemberExternalService(
    private val circuitBreaker: CircuitBreaker
) : MemberExternalQueryService {
    override fun getMember(no: Int): MemberModel {
        val checkedSupplier: CheckedFunction0<String> =
            CircuitBreaker.decorateCheckedSupplier(circuitBreaker) { throw RuntimeException("?") }
        val result = Try.of(checkedSupplier).recover { "Recovery!" }

        TODO("")
    }
}
