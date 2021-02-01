package com.aditmodhvadia.modules.users.data

import com.aditmodhvadia.models.User

interface UserDataSource {
    fun retrieveUsers(): Collection<User>
}