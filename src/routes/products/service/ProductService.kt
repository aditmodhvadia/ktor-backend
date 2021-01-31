package com.aditmodhvadia.routes.products.service

import com.aditmodhvadia.models.Product

interface ProductService {
    fun findAll(): Collection<Product>
}