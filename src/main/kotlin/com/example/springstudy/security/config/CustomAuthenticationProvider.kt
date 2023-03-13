package com.example.springstudy.security.config

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CustomAuthenticationProvider {

//    @Throws(AuthenticationException::class)
//    override fun authenticate(authentication: Authentication): Authentication {
//        val userName: String = authentication.name
//        val password: String = authentication.credentials as String
//
//        if("jin" == userName && "1765" == password) {
//            return UsernamePasswordAuthenticationToken(userName, password, arrayListOf())
//        } else {
//            throw AuthenticationCredentialsNotFoundException("Error in authentication!");
//        }
//    }
//
//    override fun supports(authenticationType: Class<*>): Boolean {
//        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authenticationType)
//    }
}