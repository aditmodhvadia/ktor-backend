package com.aditmodhvadia.routes.products.service

import com.aditmodhvadia.modules.products.service.InMemoryProductService
import com.aditmodhvadia.modules.products.service.ProductService
import com.aditmodhvadia.modules.products.data.InMemoryProductDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class InMemoryProductServiceTest {
    private val mockDataSource: InMemoryProductDataSource = mockk(relaxed = true)
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
        val productId = 1L
        // when
        userService.findOne(productId)

        // then
        verify(exactly = 1) { mockDataSource.retrieveProduct(productId) }
    }
}