package com.aditmodhvadia.routes.products.service

import com.aditmodhvadia.models.User

interface ProductService {
    fun findAll(): Collection<User>
}