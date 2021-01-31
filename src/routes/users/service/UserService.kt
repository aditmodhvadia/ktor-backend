package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.models.User

interface UserService {
    fun findAll(): Collection<User>
}