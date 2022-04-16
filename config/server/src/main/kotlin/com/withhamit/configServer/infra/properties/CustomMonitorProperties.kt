package com.withhamit.configServer.infra.properties

import org.springframework.boot.context.properties.*

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.cloud.config.monitor.custom")
data class CustomMonitorProperties(
    var profiles: List<String> = mutableListOf("dev", "alpha", "real", "beta")
)
