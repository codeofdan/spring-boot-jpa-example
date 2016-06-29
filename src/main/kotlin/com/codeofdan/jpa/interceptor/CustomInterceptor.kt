package com.codeofdan.jpa.interceptor

import com.codeofdan.jpa.model.Person
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Interceptor that, if the container redirects to an error page (or if the user requested /error),
 * will print all the people to the console
 */
@Component
open class CustomInterceptor : HandlerInterceptorAdapter() {

    @PersistenceContext
    lateinit open var entityManager: EntityManager

    val objectMapper: ObjectMapper = ObjectMapper()

    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?,
                           handler: Any?): Boolean {

        if ("/error".equals(request?.servletPath)) {
            println("Maybe the console wanted some people?")

            entityManager.createQuery("from Person", Person::class.java).resultList.forEach {
                println(it.name)
            }

        }

        return true
    }
}
