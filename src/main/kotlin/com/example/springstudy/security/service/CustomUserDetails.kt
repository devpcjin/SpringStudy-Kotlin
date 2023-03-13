package com.example.springstudy.security.service

import com.example.springstudy.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
        private val userName: String,
        private val password: String,
        private val authority: String
) : UserDetails {

    override fun getUsername(): String? {
        return userName
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(authority))
    }


    override fun isAccountNonExpired(): Boolean {
        return true // 계정이 만료되거나 잠기지 않는다.
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}