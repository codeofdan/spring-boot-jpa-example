package com.codeofdan.jpa.config

import com.codeofdan.jpa.interceptor.CustomInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Configuration class to declare our interceptor across all paths
 */
@Configuration
open class WebConfig : WebMvcConfigurerAdapter() {

    @Autowired
    lateinit open var interceptor: CustomInterceptor

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(interceptor)?.addPathPatterns("/**")
    }
}
