package com.example.study.blog

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:secret.yml")
@ConfigurationProperties("secret")
data class SecretProperties(
    val kakaoApiKey: String
) {
}