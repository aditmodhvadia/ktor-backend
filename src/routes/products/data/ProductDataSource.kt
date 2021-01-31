package com.aditmodhvadia.routes.products.data

import com.aditmodhvadia.models.Product

interface ProductDataSource {
    fun retrieveProducts(): Collection<Product>
}