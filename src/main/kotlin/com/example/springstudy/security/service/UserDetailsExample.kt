package com.example.springstudy.security.service

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsExample(
        private val userName: String,
        private val password: String,
) : UserDetails {


    override fun getUsername(): String {
        return userName
    }

    override fun getPassword(): String {
        return password
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("READ"))
    }


    /**
     * true return 시 사용자가 항상 활성화되고 사용가능하다는 의미
     */
    override fun isAccountNonExpired(): Boolean {
        return true
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