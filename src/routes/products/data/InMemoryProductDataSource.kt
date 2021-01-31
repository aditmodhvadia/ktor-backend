package com.aditmodhvadia.routes.products.data

import com.aditmodhvadia.models.User

class InMemoryProductDataSource : ProductDataSource {
    private val users = mutableListOf(
        User(1),
        User(2),
        User(3),
        User(4)
    )

    override fun retrieveProducts(): Collection<User> = users
}