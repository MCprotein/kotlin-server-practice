package com.example.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class StudyApplication

fun main(args: Array<String>) {
	runApplication<StudyApplication>(*args)
}
