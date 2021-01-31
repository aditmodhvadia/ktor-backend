package com.aditmodhvadia.routes.users.data

import com.aditmodhvadia.User

interface UserDataSource {
    fun retrieveUsers(): Collection<User>
}