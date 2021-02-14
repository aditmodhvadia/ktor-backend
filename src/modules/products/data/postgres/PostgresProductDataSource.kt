package com.aditmodhvadia.modules.products.data.postgres

import com.aditmodhvadia.database.postgres.PostgreSqlDatabase.runInDatabase
import com.aditmodhvadia.models.ProductDto
import com.aditmodhvadia.modules.products.data.ProductDataSource
import java.util.stream.Collectors
import java.util.stream.StreamSupport

class PostgresProductDataSource(private val test: Boolean = false) : ProductDataSource {
    override fun retrieveProducts(): Collection<ProductDto> {
        return runInDatabase(test) {
            val products = Product.all()
            StreamSupport.stream(products.map { it.toDto() }.spliterator(), false).collect(Collectors.toList())
        }
    }

    override fun retrieveProduct(productId: Int): ProductDto {
        return runInDatabase(test) {
            Product.findById(productId)?.toDto() ?: throw NoSuchElementException("Product with given id not found")
        }
    }


    private fun Product.toDto(): ProductDto {
        return ProductDto(this.id.value, this.name, this.price, this.department)
    }
}