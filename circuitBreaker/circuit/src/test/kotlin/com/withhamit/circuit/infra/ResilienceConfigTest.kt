package com.withhamit.circuit.infra

import com.withhamit.circuit.application.member.*
import io.github.resilience4j.circuitbreaker.*
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.*
import io.vavr.*
import io.vavr.control.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.*

@ExtendWith(MockKExtension::class)
internal class ResilienceConfigTest {

    @MockK
    private lateinit var memberExternalQueryService: MemberExternalQueryService

    private lateinit var memberQueryService: MemberQueryService

    @BeforeEach
    fun setUp() {
        memberQueryService = MemberQueryService(memberExternalQueryService)
    }

    @Test
    fun test() {
        // given
        val circuitBreaker = getCircuitBreaker()
        val throwExceptionSupplier: CheckedFunction0<String> =
            CircuitBreaker.decorateCheckedSupplier(circuitBreaker) { throw RuntimeException("?") }
        val recoveryText = "Recovery!"
        // when
        val result = Try.of(throwExceptionSupplier).recover { recoveryText }
        // then
        assertTrue(result.isSuccess)
        assertEquals(recoveryText, result.get())
    }

    @Test
    fun `member 조회 에러 - 총 10번 실행 에러는 10번 나지만 함수호출은 5번`() {
        // given
        val maxErrorCount = 5
        val callCount = maxErrorCount + 5
        var errorCount = 0

        val circuitBreaker = getCircuitBreaker(maxErrorCount)
        val decorated = CircuitBreaker.decorateFunction(circuitBreaker, memberQueryService::getMember)

        // mock
        every { memberExternalQueryService.getMember(any()) } throws RuntimeException("error")

        // when
        for (i in 0 until callCount) {
            try {
                decorated.apply(i)
            } catch (ignore: Exception) {
                errorCount++
            }
        }

        // then
        assertEquals(callCount, errorCount)
        verify(exactly = maxErrorCount) { memberExternalQueryService.getMember(any()) }
        for (i in 0 until maxErrorCount) {
            verify(exactly = 1) { memberExternalQueryService.getMember(i) }
        }
    }

    private fun getCircuitBreaker(maxErrorCount: Int = 10): CircuitBreaker {
        val config = CircuitBreakerConfig.custom()
            .failureRateThreshold(20f)
            .slidingWindow(10, maxErrorCount, CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
            .build()
        val registry = CircuitBreakerRegistry.of(config)
        return registry.circuitBreaker("test")
    }
}
