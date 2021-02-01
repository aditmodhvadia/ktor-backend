package com.aditmodhvadia.modules.products.service

import com.aditmodhvadia.models.Product

interface ProductService {
    fun findAll(): Collection<Product>
    fun findOne(productId: Long): Product
}