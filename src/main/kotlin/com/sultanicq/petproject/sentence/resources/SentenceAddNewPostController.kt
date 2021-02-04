package com.sultanicq.petproject.sentence.resources

import com.sultanicq.petproject.sentence.application.SentenceAddService
import com.sultanicq.petproject.sentence.domain.EmptySentenceNotAllowed
import com.sultanicq.petproject.sentence.domain.SentenceAlreadyPresent
import com.sultanicq.petproject.sentence.domain.SentenceDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap

@RestController
class SentenceAddNewPostController @Autowired constructor(private val service: SentenceAddService) {

    @PostMapping("/api/sentence")
    @ResponseBody
    fun process(@RequestBody sentence: SentenceDTO): ResponseEntity<Map<String?, String?>> {
        try {
            service.execute(sentence)
        } catch (e: SentenceAlreadyPresent) {
            return ResponseEntity.ok(mapOf("status" to "ok"))
        } catch (e: EmptySentenceNotAllowed) {
            return ResponseEntity( mapOf("message" to e.message), HttpStatus.BAD_REQUEST)
        }

        return ResponseEntity(mapOf("status" to "ok"), HttpStatus.CREATED)
    }
}