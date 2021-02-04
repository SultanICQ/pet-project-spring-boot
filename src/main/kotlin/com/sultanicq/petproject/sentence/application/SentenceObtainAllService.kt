package com.sultanicq.petproject.sentence.application

import com.sultanicq.petproject.sentence.infraestructure.SentenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SentenceObtainAllService @Autowired constructor( private val sentenceRepository: SentenceRepository){

}