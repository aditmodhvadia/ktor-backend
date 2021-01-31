package com.aditmodhvadia.routes.users.data

import com.aditmodhvadia.models.User
import com.aditmodhvadia.routes.products.data.ProductDataSource

class InMemoryUserDataSource : ProductDataSource {
    private val users = mutableListOf(
        User(1),
        User(2),
        User(3),
        User(4)
    )

    override fun retrieveProducts(): Collection<User> = users
}