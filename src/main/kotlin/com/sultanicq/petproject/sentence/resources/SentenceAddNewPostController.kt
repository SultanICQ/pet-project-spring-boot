package com.sultanicq.petproject.sentence.resources

import com.sultanicq.petproject.sentence.application.SentenceAddService
import com.sultanicq.petproject.sentence.domain.SentenceDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SentenceAddNewPostController @Autowired constructor(private val service: SentenceAddService) {

    @PostMapping("/api/sentence")
    fun process(@RequestBody sentence: SentenceDTO): ResponseEntity<String> {
        service.execute(sentence)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}