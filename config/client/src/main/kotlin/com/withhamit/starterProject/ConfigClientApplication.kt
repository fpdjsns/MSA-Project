package com.withhamit.starterProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.*
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ConfigClientApplication

fun main(args: Array<String>) {
	runApplication<ConfigClientApplication>(*args)
}
