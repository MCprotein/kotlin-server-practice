package com.example.study.blog.service

import com.example.study.blog.SecretProperties
import com.example.study.blog.dto.BlogDto
import com.example.study.blog.entity.WordCount
import com.example.study.blog.repository.WordRepository
import com.example.study.core.exception.InvalidInputException
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.bodyToMono



@Service
class BlogService(
    val secretProperties: SecretProperties,
    val wordRepository: WordRepository
) {

    fun searchKakao(blogDto: BlogDto): String? {

        val webClient = WebClient
            .builder()
            .baseUrl("https://dapi.kakao.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val response = webClient
            .get()
            .uri { it.path("/v2/search/blog")
                .queryParam("query", blogDto.query)
                .queryParam("sort", blogDto.sort)
                .queryParam("page", blogDto.page)
                .queryParam("size", blogDto.size)
                .build() }
            .header("Authorization", "KakaoAK ${secretProperties.kakaoApiKey}")
            .retrieve()
            .bodyToMono<String>()
        val result = response.block()

        val lowQuery: String = blogDto.query.lowercase()
        val word: WordCount = wordRepository.findById(lowQuery).orElse(WordCount(lowQuery))
        word.cnt++

        wordRepository.save(word)

        return result
    }

    fun searchWordRank(): List<WordCount> = wordRepository.findTop10ByOrderByCntDesc()
}