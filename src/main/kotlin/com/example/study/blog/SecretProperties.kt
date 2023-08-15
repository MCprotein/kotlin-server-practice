package com.example.study.blog

import org.jetbrains.annotations.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource

@ConfigurationProperties("secret")
data class SecretProperties(
    @field:NotNull
    val kakaoApiKey: String
) {
}