package com.aditmodhvadia.routes.products.data

import com.aditmodhvadia.models.User

interface ProductDataSource {
    fun retrieveProducts(): Collection<User>
}