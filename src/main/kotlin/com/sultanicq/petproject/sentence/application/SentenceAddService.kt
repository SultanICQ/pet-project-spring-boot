package com.sultanicq.petproject.sentence.application

import com.sultanicq.petproject.sentence.domain.EmptySentenceNotAllowed
import com.sultanicq.petproject.sentence.domain.Sentence
import com.sultanicq.petproject.sentence.domain.SentenceDTO
import com.sultanicq.petproject.sentence.infraestructure.SentenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SentenceAddService @Autowired constructor(private val sentenceRepository: SentenceRepository) {
    fun execute(sentence: SentenceDTO) {

        if (sentence.sentence.trim().isEmpty()) {
            throw EmptySentenceNotAllowed()
        }

        val newSentence = Sentence(
            UUID.randomUUID().toString(),
            sentence.sentence
        )

        sentenceRepository.save(newSentence)
    }
}