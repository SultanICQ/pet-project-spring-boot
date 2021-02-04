package com.sultanicq.petproject.sentence.infraestructure

import com.sultanicq.petproject.sentence.domain.Sentence
import org.springframework.data.jpa.repository.JpaRepository

interface SentenceRepository: JpaRepository<Sentence, String> {
}