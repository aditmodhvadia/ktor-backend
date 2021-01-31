package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.models.User
import com.aditmodhvadia.routes.products.data.ProductDataSource
import com.aditmodhvadia.routes.products.service.ProductService

class InMemoryUserService(private val userDataSource: ProductDataSource) : ProductService {
    override fun findAll(): Collection<User> = userDataSource.retrieveProducts()
}