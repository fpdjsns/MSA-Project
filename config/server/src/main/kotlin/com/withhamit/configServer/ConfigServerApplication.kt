package com.withhamit.configServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.*
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.*

@SpringBootApplication
@EnableConfigServer
@ConfigurationPropertiesScan
class ConfigServerApplication

fun main(args: Array<String>) {
	runApplication<ConfigServerApplication>(*args)
}
