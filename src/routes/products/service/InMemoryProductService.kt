package com.aditmodhvadia.routes.products.service

import com.aditmodhvadia.models.User
import com.aditmodhvadia.routes.products.data.ProductDataSource

class InMemoryProductService(private val productDataSource: ProductDataSource) : ProductService {
    override fun findAll(): Collection<User> = productDataSource.retrieveProducts()
}