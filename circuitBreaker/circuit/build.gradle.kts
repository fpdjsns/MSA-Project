val resilience4jVersion = "1.7.0"

dependencies {
    implementation("io.github.resilience4j:resilience4j-spring-boot2:${resilience4jVersion}")

    implementation("io.github.resilience4j:resilience4j-circuitbreaker:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-ratelimiter:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-retry:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-bulkhead:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-cache:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-timelimiter:${resilience4jVersion}")

    implementation("io.github.resilience4j:resilience4j-kotlin:${resilience4jVersion}")
}
