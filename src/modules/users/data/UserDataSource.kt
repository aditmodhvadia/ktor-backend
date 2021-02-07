package com.aditmodhvadia.modules.users.data

import com.aditmodhvadia.models.UserDto

interface UserDataSource {
    fun retrieveUsers(): Collection<UserDto>
}