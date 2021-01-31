package com.aditmodhvadia.routes.products

import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import com.aditmodhvadia.routes.products.data.ProductDataSource
import com.aditmodhvadia.routes.products.service.InMemoryProductService
import com.aditmodhvadia.routes.products.service.ProductService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

private val dataSource: ProductDataSource = InMemoryProductDataSource()
private val productService: ProductService = InMemoryProductService(dataSource)

fun Route.product() {
    route("products") {
        get {
            call.respond(productService.findAll())
        }

        /*get("{productId}") {

        }*/
    }
}