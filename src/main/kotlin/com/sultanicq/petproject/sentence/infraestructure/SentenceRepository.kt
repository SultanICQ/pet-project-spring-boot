package com.sultanicq.petproject.sentence.infraestructure

import com.sultanicq.petproject.sentence.domain.Sentence
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SentenceRepository: JpaRepository<Sentence, String> {
    fun findBySentence(sentence: String): Optional<Sentence>
}