package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.models.User
import com.aditmodhvadia.routes.users.data.UserDataSource

class InMemoryUserService(private val userDataSource: UserDataSource) : UserService {
    override fun findAll(): Collection<User> = userDataSource.retrieveUsers()
}