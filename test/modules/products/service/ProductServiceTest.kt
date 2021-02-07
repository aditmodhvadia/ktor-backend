package com.aditmodhvadia.modules.products.service

import com.aditmodhvadia.modules.products.data.ProductDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ProductServiceTest {
    private val mockDataSource: ProductDataSource = mockk(relaxed = true)
    private val userService: ProductService = InMemoryProductService(mockDataSource)

    @Test
    fun `should get all products`() {
        // when
        userService.findAll()

        // then
        verify(exactly = 1) { mockDataSource.retrieveProducts() }
    }

    @Test
    fun `should get product`() {
        // given
        val productId = 1
        // when
        userService.findOne(productId)

        // then
        verify(exactly = 1) { mockDataSource.retrieveProduct(productId) }
    }
}