package com.aditmodhvadia.routes.users

import com.aditmodhvadia.routes.users.data.InMemoryUserDataSource
import com.aditmodhvadia.routes.users.data.UserDataSource
import com.aditmodhvadia.routes.users.service.InMemoryUserService
import com.aditmodhvadia.routes.users.service.UserService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

private val dataSource: UserDataSource = InMemoryUserDataSource()
private val userService: UserService = InMemoryUserService(dataSource)

fun Route.user() {
    route("users") {
        get {
            call.respond(userService.findAll())
        }
    }
}