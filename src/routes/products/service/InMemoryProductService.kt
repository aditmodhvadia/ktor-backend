package com.aditmodhvadia.routes.products.service

import com.aditmodhvadia.models.Product
import com.aditmodhvadia.routes.products.data.ProductDataSource

class InMemoryProductService(private val productDataSource: ProductDataSource) : ProductService {
    override fun findAll(): Collection<Product> = productDataSource.retrieveProducts()
    override fun findOne(productId: Long): Product = productDataSource.retrieveProduct(productId)
}