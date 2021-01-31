package com.aditmodhvadia.routes.products.data

import com.aditmodhvadia.models.Product

class InMemoryProductDataSource : ProductDataSource {
    private val products = mutableListOf<Product>(
        Product(1, "Chips Potato Reg 43g", "$454.49", "Computers"),
        Product(2, "Beef - Rib Eye Aaa", "$371.53", "Grocery"),
        Product(3, "Extract - Raspberry", "$65.31", "Garden"),
        Product(4, "Cheese - Montery Jack", "$415.48", "Books")
    )

    override fun retrieveProducts(): Collection<Product> = products
    override fun retrieveProduct(productId: Long): Product {
        return products.find { it.id == productId } ?: throw NoSuchElementException("Product with given id not found")
    }
}