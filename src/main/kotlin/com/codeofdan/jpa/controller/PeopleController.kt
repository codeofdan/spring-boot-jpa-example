package com.codeofdan.jpa.controller

import com.codeofdan.jpa.respository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
open class PeopleController {

    @Autowired
    lateinit open var peopleRepo: PeopleRepository

    @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
    open fun getAllPeople() = peopleRepo.findAll()

}
