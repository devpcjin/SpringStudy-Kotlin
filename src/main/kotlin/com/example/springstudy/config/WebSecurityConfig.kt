package com.example.springstudy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import kotlin.jvm.Throws

@Configuration
class WebSecurityConfig(): WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        val userDetailsService = InMemoryUserDetailsManager()

        val user = User.withUsername("jin")
                .password("1765")
                .authorities("read")
                .build()

        userDetailsService.createUser(user)

        /**
         * configure() 메서드에서 UserDetailsService와 PasswordEncoder 설정
         */
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
    }

    @Throws
    override fun configure(http: HttpSecurity){
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated() // 모든 요청에 인증이 필요하다.
//                .anyRequest().permitAll() // 모든 요청에 인증 없이 허용
    }
}