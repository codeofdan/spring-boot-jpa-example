package com.codeofdan.jpa.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Person entity
 */
@Entity
open class Person(
        @Id @GeneratedValue(
                strategy = javax.persistence.GenerationType.IDENTITY) open var id: Long? = null,
        open var name: String = "",
        open var dob: LocalDate = LocalDate.MIN
)
