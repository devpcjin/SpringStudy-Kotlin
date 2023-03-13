package com.example.springstudy.security.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class CustomUserDetailsService(
        private val users: List<UserDetails>
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return users.stream()
                .filter { u -> u.username == username } // 사용자의 목록에서 요청된 사용자와 일치하는 항목 필터링
                .findFirst() // 일치하는 사용자가 있으면 반환
                .orElseThrow {
                    throw UsernameNotFoundException("User not found")
                } // 사용자 이름이 존재하지 않으면 예외처리
    }
}