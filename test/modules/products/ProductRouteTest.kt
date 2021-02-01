package com.aditmodhvadia.routes.products

import com.aditmodhvadia.installGson
import com.aditmodhvadia.models.Product
import com.aditmodhvadia.main
import com.aditmodhvadia.modules.products.product
import com.google.gson.GsonBuilder
import io.ktor.http.*
import io.ktor.server.testing.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

internal class ProductRouteTest {
    private val gson by lazy { GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create() }

    @Nested
    @DisplayName("GET /products")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetProducts {
        @Test
        fun `should return collection of products with success response`() {
            // when, then
            withTestApplication({ product(testing = true).apply { installGson() } }) {
                handleRequest(HttpMethod.Get, "/products").apply {
                    assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                    assertThat(response.contentType().toString())
                        .contains(ContentType.Application.Json.toString())
                    assertThat(response.content).isNotEmpty

                    val products = gson.fromJson(response.content, Array<Product>::class.java)
                    assertThat(products).allSatisfy {
                        assertThat(it.id).isGreaterThanOrEqualTo(1)
                        assertThat(it.name).isNotBlank
                        assertThat(it.department).isNotBlank
                        assertThat(it.price).isNotBlank
                    }
                }
            }
        }
    }

    @Nested
    @DisplayName("GET /products/productId")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetProduct {
        @Test
        fun `should return ok response for valid product id`() {
            // given
            val productId = 1

            // when/then
            withTestApplication({ product(testing = true).apply { installGson() } }) {
                handleRequest(HttpMethod.Get, "/products/$productId").apply {
                    assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                    assertThat(response.contentType().toString())
                        .contains(ContentType.Application.Json.toString())
                    assertThat(response.content).isNotEmpty

                    val products = gson.fromJson(response.content, Product::class.java)
                    assertThat(products.id).isGreaterThanOrEqualTo(1)
                    assertThat(products.name).isNotBlank
                    assertThat(products.department).isNotBlank
                    assertThat(products.price).isNotBlank
                }
            }
        }

        @Test
        fun `should return error no content when product not found for given product id`() {
            // given
            val productId = -1

            // when/then
            withTestApplication({ product(testing = true).apply { installGson() } }) {
                handleRequest(HttpMethod.Get, "/products/$productId").apply {
                    assertThat(response.status()).isEqualTo(HttpStatusCode.NoContent)
                    assertThat(response.content).isEqualTo("Product with given id not found")
                }
            }
        }

        @Test
        fun `should return bad request for invalid non long product id`() {
            // given
            val productId = "invalid_product_id"

            // when/then
            withTestApplication({ product(testing = true).apply { installGson() } }) {
                handleRequest(HttpMethod.Get, "/products/$productId").apply {
                    assertThat(response.status()).isEqualTo(HttpStatusCode.BadRequest)
                    assertThat(response.content).isEqualTo("Specified product id is incorrect")
                }
            }
        }
    }
}