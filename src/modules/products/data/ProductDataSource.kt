package com.aditmodhvadia.modules.products.data

import com.aditmodhvadia.models.ProductDto

interface ProductDataSource {
    fun retrieveProducts(): Collection<ProductDto>
    fun retrieveProduct(productId: Int): ProductDto
}