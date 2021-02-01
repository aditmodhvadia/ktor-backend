package com.aditmodhvadia.modules.users

import com.aditmodhvadia.installGson
import com.aditmodhvadia.main
import com.aditmodhvadia.models.User
import com.google.gson.GsonBuilder
import io.ktor.http.*
import io.ktor.server.testing.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserModuleTest {
    private val gson by lazy { GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create() }

    @Test
    fun `should return collection of users with success response`() {
        // when, then
        withTestApplication({ user(testing = true).apply { installGson() } }) {
            handleRequest(HttpMethod.Get, "/users").apply {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                assertThat(response.contentType().toString())
                    .contains(ContentType.Application.Json.toString())
                assertThat(response.content).isNotEmpty

                val users = gson.fromJson(response.content, Array<User>::class.java)
                assertThat(users).allSatisfy { assertThat(it.id).isGreaterThanOrEqualTo(1) }
            }
        }
    }
}