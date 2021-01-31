package com.aditmodhvadia.routes.products

import com.aditmodhvadia.module
import io.ktor.http.*
import io.ktor.server.testing.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ProductRouteTest {

    @Test
    fun `should return collection of products with success response`() {
        // when, then
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/products").apply {
                Assertions.assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                Assertions.assertThat(response.contentType().toString())
                    .contains(ContentType.Application.Json.toString())
                Assertions.assertThat(response.content).isNotEmpty()
            }
        }
    }
}