package com.aditmodhvadia.authentication.user

import com.aditmodhvadia.models.UserDto

interface UserAuthentication {
    fun findUserById(id: Int): UserDto
}