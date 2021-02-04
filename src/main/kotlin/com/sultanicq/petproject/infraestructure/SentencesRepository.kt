package com.sultanicq.petproject.infraestructure

import com.sultanicq.petproject.sentence.domain.Sentence
import org.springframework.data.jpa.repository.JpaRepository

interface SentencesRepository: JpaRepository<Sentence, String> {
}