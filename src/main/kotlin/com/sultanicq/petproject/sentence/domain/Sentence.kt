package com.sultanicq.petproject.sentence.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="sentences")
data class Sentence (@Id val id: String, val sentence:String )