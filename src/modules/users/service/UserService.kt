package com.aditmodhvadia.modules.users.service

import com.aditmodhvadia.models.UserDto

interface UserService {
    fun findAll(): Collection<UserDto>
}