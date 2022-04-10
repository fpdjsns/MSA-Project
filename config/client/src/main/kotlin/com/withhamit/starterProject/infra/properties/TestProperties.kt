package com.withhamit.starterProject.infra.properties

import org.springframework.boot.context.properties.*
import org.springframework.cloud.context.config.annotation.*

@RefreshScope
@ConstructorBinding
@ConfigurationProperties(prefix = "test")
data class TestProperties(
    var message: String = ""
)
