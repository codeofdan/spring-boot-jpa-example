package com.codeofdan.jpa.respository

import com.codeofdan.jpa.model.Person
import org.springframework.data.repository.CrudRepository

interface PeopleRepository : CrudRepository<Person, Long> {

}
