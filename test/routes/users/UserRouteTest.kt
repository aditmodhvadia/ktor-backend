package com.aditmodhvadia.routes.users

import com.aditmodhvadia.module
import io.ktor.http.*
import io.ktor.server.testing.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class UserRouteTest {

    @Test
    fun `should return collection of users with success response`() {
        // when, then
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/users").apply {
                Assertions.assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                Assertions.assertThat(response.contentType().toString())
                    .contains(ContentType.Application.Json.toString())
                Assertions.assertThat(response.content).isNotEmpty()
            }
        }
    }
}