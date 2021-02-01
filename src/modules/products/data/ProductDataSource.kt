package com.aditmodhvadia.modules.products.data

import com.aditmodhvadia.models.Product

interface ProductDataSource {
    fun retrieveProducts(): Collection<Product>
    fun retrieveProduct(productId: Long): Product
}