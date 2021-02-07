package com.aditmodhvadia.modules.users.service

import com.aditmodhvadia.models.User
import com.aditmodhvadia.modules.users.data.UserDataSource
import com.aditmodhvadia.modules.users.service.UserService

class InMemoryUserService(private val userDataSource: UserDataSource) : UserService {
    override fun findAll(): Collection<User> = userDataSource.retrieveUsers()
}