package com.aditmodhvadia.modules.users.data

import com.aditmodhvadia.models.UserDto

class InMemoryUserDataSource : UserDataSource {
    private val users = mutableListOf(
        UserDto(1),
        UserDto(2),
        UserDto(3),
        UserDto(4)
    )

    override fun retrieveUsers(): Collection<UserDto> = users
}