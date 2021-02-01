package com.aditmodhvadia

import com.google.gson.GsonBuilder
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*

fun Application.installGson(block: GsonBuilder.() -> Unit = {}) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
            serializeNulls()
            block()
        }
    }
}
