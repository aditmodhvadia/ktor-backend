package com.aditmodhvadia.modules.users

import com.aditmodhvadia.installGson
import com.aditmodhvadia.models.UserDto
import com.aditmodhvadia.runTestApplication
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
        runUserTestApplication() {
            handleRequest(HttpMethod.Get, "/users").apply {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                assertThat(response.contentType().toString())
                    .contains(ContentType.Application.Json.toString())
                assertThat(response.content).isNotEmpty

                val users = gson.fromJson(response.content, Array<UserDto>::class.java)
                assertThat(users).allSatisfy { assertThat(it.id).isGreaterThanOrEqualTo(1) }
            }
        }
    }

    fun runUserTestApplication(block: TestApplicationEngine.() -> Unit) {
        runTestApplication({ user(testing = true).apply { installGson() } }) {
            block()
        }
    }
}