package com.withhamit.circuit.infra

import io.github.resilience4j.circuitbreaker.*
import org.springframework.context.annotation.*
import java.io.*
import java.time.*
import java.util.concurrent.*

@Configuration
class ResilienceConfig {
    companion object {
        private const val CIRCUIT_BREAKER_NAME = "CircuitBreaker"
    }

    @Bean
    fun circuitBreaker(): CircuitBreaker {
        val config = CircuitBreakerConfig.custom()
            .failureRateThreshold(50F)
            .waitDurationInOpenState(Duration.ofMillis(1000))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(2)
            .recordExceptions(IOException::class.java, TimeoutException::class.java)
            .ignoreExceptions(BusinessException::class.java)
            .build()
        return CircuitBreakerRegistry.of(config).circuitBreaker(CIRCUIT_BREAKER_NAME)
    }
}

class BusinessException : RuntimeException()
