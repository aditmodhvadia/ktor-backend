package com.aditmodhvadia.routes.users

import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import com.aditmodhvadia.routes.products.data.ProductDataSource
import com.aditmodhvadia.routes.products.service.InMemoryProductService
import com.aditmodhvadia.routes.products.service.ProductService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

private val dataSource: ProductDataSource = InMemoryProductDataSource()
private val userService: ProductService = InMemoryProductService(dataSource)

fun Route.user() {
    route("users") {
        get {
            call.respond(userService.findAll())
        }
    }
}