package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.User

interface UserService {
    fun findAll(): Collection<User>
}