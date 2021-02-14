package com.aditmodhvadia.modules.users.service

import com.aditmodhvadia.models.UserDto
import com.aditmodhvadia.modules.users.data.UserDataSource

class InMemoryUserService(private val userDataSource: UserDataSource) : UserService {
    override fun findAll(): Collection<UserDto> = userDataSource.retrieveUsers()
}