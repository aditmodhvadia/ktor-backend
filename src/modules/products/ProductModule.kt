package com.aditmodhvadia.modules.products

import com.aditmodhvadia.modules.products.data.InMemoryProductDataSource
import com.aditmodhvadia.modules.products.data.ProductDataSource
import com.aditmodhvadia.modules.products.service.InMemoryProductService
import com.aditmodhvadia.modules.products.service.ProductService
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.security.InvalidParameterException

private val dataSource: ProductDataSource = InMemoryProductDataSource()
private val productService: ProductService = InMemoryProductService(dataSource)

fun Application.product(testing: Boolean = false) {
    install(StatusPages) {
        exception<InvalidParameterException> {
            call.respond(HttpStatusCode.BadRequest, it.message ?: "BAD REQUEST")
        }
        exception<NoSuchElementException> {
            call.respond(HttpStatusCode.NoContent, it.message ?: "No such element found")
        }
    }
    routing {
        route("products") {
            get {
                call.respond(productService.findAll())
            }

            get("{productId}") {
                try {
                    call.parameters["productId"]?.toLong()
                } catch (e: NumberFormatException) {
                    throw InvalidParameterException("Specified product id is incorrect")
                }?.let { productId ->
                    call.respond(productService.findOne(productId))
                }
            }
        }
    }
}