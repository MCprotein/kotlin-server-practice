package com.example.study

import com.example.study.blog.SecretProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(SecretProperties::class)
@SpringBootApplication
class StudyApplication

fun main(args: Array<String>) {
	runApplication<StudyApplication>(*args)
}
