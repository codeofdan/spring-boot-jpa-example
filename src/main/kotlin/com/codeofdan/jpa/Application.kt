package com.codeofdan.jpa

import com.codeofdan.jpa.model.Person
import com.codeofdan.jpa.respository.PeopleRepository
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDate

@SpringBootApplication
open class Application {

    @Autowired
    lateinit open var peopleRepo: PeopleRepository

    /**
     * Allows Jackson to work properly with JDK8 LocalDate class, Hibernate lazy proxies, and Kotlin
     * classes
     */
    @Bean open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder().
                modulesToInstall(KotlinModule(), Hibernate5Module()).
                featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).
                serializationInclusion(JsonInclude.Include.NON_NULL)
    }

    /**
     * Initialise the database on startup with some data
     */
    @Bean
    open fun commandLineRunner() = CommandLineRunner {
        val adam = Person(name = "Adam Brown", dob = LocalDate.of(1990,1,2))
        val charlie = Person(name = "Charlie Davis", dob = LocalDate.of(1965, 12, 28))
        val edward = Person(name = "Edward Fuller", dob = LocalDate.of(1989, 3, 31))
        val georgie = Person(name = "Georgie Higgins", dob = LocalDate.of(1996, 6, 4))
        val isabelle = Person(name = "Isabelle Jones", dob = LocalDate.of(1986, 2, 17))
        val kelly = Person(name = "Kelly Long", dob = LocalDate.of(1983, 9, 11))

        peopleRepo.save(adam)
        peopleRepo.save(charlie)
        peopleRepo.save(edward)
        peopleRepo.save(georgie)
        peopleRepo.save(isabelle)
        peopleRepo.save(kelly)

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}