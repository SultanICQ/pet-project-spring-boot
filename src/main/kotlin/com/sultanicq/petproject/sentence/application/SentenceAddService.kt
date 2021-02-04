package com.sultanicq.petproject.sentence.application

import com.sultanicq.petproject.sentence.domain.EmptySentenceNotAllowed
import com.sultanicq.petproject.sentence.domain.Sentence
import com.sultanicq.petproject.sentence.domain.SentenceAlreadyPresent
import com.sultanicq.petproject.sentence.domain.SentenceDTO
import com.sultanicq.petproject.sentence.infraestructure.SentenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SentenceAddService @Autowired constructor(private val sentenceRepository: SentenceRepository) {
    fun execute(dto: SentenceDTO) {

        verifyEmptySentence(dto)
        verifySentenceDuplicated(dto)

        val newSentence = Sentence(
            UUID.randomUUID().toString(),
            dto.sentence
        )

        sentenceRepository.save(newSentence)
    }

    private fun verifySentenceDuplicated(dto: SentenceDTO): Boolean {
        val current = sentenceRepository.findBySentence(dto.sentence)
        if (current.isPresent) {
            throw SentenceAlreadyPresent(dto.sentence)
        }
        return false
    }

    private fun verifyEmptySentence(dto: SentenceDTO) {
        if (dto.sentence.trim().isEmpty()) {
            throw EmptySentenceNotAllowed()
        }
    }
}