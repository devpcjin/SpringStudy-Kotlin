package com.example.springstudy.user.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(value = "User", tags = ["User"])
@RestController
@RequestMapping("/v1/user")
class UserController {
    @ApiOperation(value = "회원가입")
    @GetMapping("/join")
    fun joinUser(): ResponseEntity<String?> {
        return ResponseEntity("join", HttpStatus.OK)
    }
}