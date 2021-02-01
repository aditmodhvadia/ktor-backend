package com.aditmodhvadia.routes.users.service

import com.aditmodhvadia.modules.users.data.InMemoryUserDataSource
import com.aditmodhvadia.modules.users.service.InMemoryUserService
import com.aditmodhvadia.modules.users.service.UserService
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class InMemoryUserServiceTest {
    private val mockDataSource: InMemoryUserDataSource = mockk(relaxed = true)
    private val userService: UserService = InMemoryUserService(mockDataSource)

    @Test
    fun `should get all users`() {
        // when
        userService.findAll()

        // then
        verify(exactly = 1) { mockDataSource.retrieveUsers() }
    }
}