package com.aditmodhvadia.modules.products.data

import com.aditmodhvadia.models.ProductDto

class InMemoryProductDataSource : ProductDataSource {
    private val products = mutableListOf(
        ProductDto(1, "Chips Potato Reg 43g", "$454.49", "Computers"),
        ProductDto(2, "Beef - Rib Eye Aaa", "$371.53", "Grocery"),
        ProductDto(3, "Extract - Raspberry", "$65.31", "Garden"),
        ProductDto(4, "Cheese - Montery Jack", "$415.48", "Books")
    )

    override fun retrieveProducts(): Collection<ProductDto> = products
    override fun retrieveProduct(productId: Int): ProductDto {
        return products.find { it.id == productId } ?: throw NoSuchElementException("Product with given id not found")
    }
}