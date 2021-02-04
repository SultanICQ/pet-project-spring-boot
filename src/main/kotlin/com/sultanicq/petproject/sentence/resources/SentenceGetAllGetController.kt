package com.sultanicq.petproject.sentence.resources

import com.sultanicq.petproject.sentence.application.SentenceObtainAllService
import com.sultanicq.petproject.sentence.domain.SentenceDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SentenceGetAllGetController @Autowired constructor(private val service: SentenceObtainAllService) {

    @GetMapping("/api/sentences")
    fun process():ResponseEntity<List<SentenceDTO>> {
        val result = service.execute()
        val dto = result.map{ SentenceDTO(it.sentence) }
        return ResponseEntity.ok( dto )
    }
}