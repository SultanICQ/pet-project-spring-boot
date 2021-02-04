package com.sultanicq.petproject.sentence.domain

class SentenceAlreadyPresent(sentence:String) : Exception("Sentence $sentence is already present")