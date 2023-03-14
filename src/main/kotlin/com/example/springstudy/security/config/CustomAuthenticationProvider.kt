package com.example.springstudy.security.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CustomAuthenticationProvider: AuthenticationProvider {

    @Autowired
    var userDetailsService: UserDetailsService? = null

    @Autowired
    var passwordEncoder: PasswordEncoder? = null

    override fun authenticate(authentication: Authentication?): Authentication {

        var userName: String = authentication!!.name
        var password: String = authentication!!.credentials.toString()

        var u: UserDetails = userDetailsService!!.loadUserByUsername(userName)

        if(passwordEncoder!!.matches(password, u.password)) {
            return UsernamePasswordAuthenticationToken(userName, password, u.authorities)
        } else {
            throw BadCredentialsException("Something went wrong!")
        }
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!! == UsernamePasswordAuthenticationToken::class
    }
}