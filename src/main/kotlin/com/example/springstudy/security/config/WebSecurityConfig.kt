package com.example.springstudy.security.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfig(): WebSecurityConfigurerAdapter() {

//    @Autowired
//    private val authenticationProvider: CustomAuthenticationProvider? = null
//
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.authenticationProvider(authenticationProvider)
//    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic()
        http.authorizeRequests().anyRequest().authenticated()
    }
}