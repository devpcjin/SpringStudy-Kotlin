package com.example.springstudy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class WebSecurityConfig(): WebSecurityConfigurerAdapter() {
    @Bean
    override fun userDetailsService(): UserDetailsService {
        val userDetailsService = InMemoryUserDetailsManager()

        val user = User.withUsername("jin")
                .password("1765")
                .authorities("read")
                .build()

        userDetailsService.createUser(user)

        return userDetailsService
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        /*
        NoOpPasswordEncoder 인스턴스는 암호화나 해시를 적용하지 않고 일반 텍스트처럼 처리
        => 운영에서는 사용하면 안된다. (@Deprecated로 지정된 이유)
         */
        return  NoOpPasswordEncoder.getInstance()
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic();
        http.authorizeRequests()
//                .anyRequest().authenticated() // 모든 요청에 인증이 필요하다.
                .anyRequest().permitAll() // 모든 요청에 인증 없이 허용
    }
}