package com.example.springstudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class SpringstudyApplication

fun main(args: Array<String>) {
    runApplication<SpringstudyApplication>(*args)
}
