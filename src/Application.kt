package com.aditmodhvadia

import com.aditmodhvadia.routes.products.product
import com.aditmodhvadia.modules.users.user
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.slf4j.event.Level
import java.security.InvalidParameterException

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
            serializeNulls()
        }
    }

    /*val client = HttpClient() {
    }*/

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        install(StatusPages) {
            exception<AuthenticationException> {
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationException> {
                call.respond(HttpStatusCode.Forbidden)
            }
            exception<InvalidParameterException> {
                call.respond(HttpStatusCode.BadRequest, it.message ?: "BAD REQUEST")
            }
            exception<NoSuchElementException> {
                call.respond(HttpStatusCode.NoContent, it.message ?: "No such element found")
            }
        }

        product()
    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()

