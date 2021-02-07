package com.aditmodhvadia

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class ApplicationTest {
    @Test
    fun testRoot() {
        runTestApplication {
            handleRequest(HttpMethod.Get, "/").apply {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                assertThat(response.content).isEqualTo("HELLO WORLD!")
            }
        }
    }

    @Test
    fun testClientMock() {
        runBlocking {
            val client = HttpClient(MockEngine) {
                engine {
                    addHandler { request ->
                        when (request.url.fullPath) {
                            "/" -> respond(
                                ByteReadChannel(byteArrayOf(1, 2, 3)),
                                headers = headersOf("X-MyHeader", "MyValue")
                            )
                            else -> respond("Not Found ${request.url.encodedPath}", HttpStatusCode.NotFound)
                        }
                    }
                }
                expectSuccess = false
            }
            assertThat(client.get<ByteArray>("/").toList()).isEqualTo(byteArrayOf(1, 2, 3).toList())
            assertThat(client.request<HttpResponse>("/").headers["X-MyHeader"]).isEqualTo("MyValue")
            assertThat(client.get<String>("/other/path")).isEqualTo("Not Found other/path")
        }
    }
}

fun runTestApplication(
    module: Application.() -> Unit = { main(testing = true) },
    block: TestApplicationEngine.() -> Unit,
) {
    withTestApplication(module) {
        block()
    }
}
