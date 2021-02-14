package com.aditmodhvadia.modules.products.service

import com.aditmodhvadia.models.ProductDto

interface ProductService {
    fun findAll(): Collection<ProductDto>
    fun findOne(productId: Int): ProductDto
}