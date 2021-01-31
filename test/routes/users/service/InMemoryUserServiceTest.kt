package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import com.aditmodhvadia.routes.products.service.InMemoryProductService
import com.aditmodhvadia.routes.products.service.ProductService
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class InMemoryUserServiceTest {
    private val mockDataSource: InMemoryProductDataSource = mockk(relaxed = true)
    private val userService: ProductService = InMemoryProductService(mockDataSource)

    @Test
    fun `should get all users`() {
        // when
        userService.findAll()

        // then
        verify(exactly = 1) { mockDataSource.retrieveProducts() }
    }
}