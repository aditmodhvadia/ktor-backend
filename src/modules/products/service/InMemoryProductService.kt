package com.aditmodhvadia.modules.products.service

import com.aditmodhvadia.models.ProductDto
import com.aditmodhvadia.modules.products.data.ProductDataSource

class InMemoryProductService(private val productDataSource: ProductDataSource) : ProductService {
    override fun findAll(): Collection<ProductDto> = productDataSource.retrieveProducts()
    override fun findOne(productId: Int): ProductDto = productDataSource.retrieveProduct(productId)
}