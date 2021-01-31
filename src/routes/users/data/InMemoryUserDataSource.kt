package com.aditmodhvadia.routes.users.data

import com.aditmodhvadia.models.User

class InMemoryUserDataSource : UserDataSource {
    private val users = mutableListOf(
        User(1),
        User(2),
        User(3),
        User(4)
    )

    override fun retrieveUsers(): Collection<User> = users
}