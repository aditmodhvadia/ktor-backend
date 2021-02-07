package com.aditmodhvadia.modules.users

import com.aditmodhvadia.modules.users.data.InMemoryUserDataSource
import com.aditmodhvadia.modules.users.data.UserDataSource
import com.aditmodhvadia.modules.users.service.InMemoryUserService
import com.aditmodhvadia.modules.users.service.UserService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

private val dataSource: UserDataSource = InMemoryUserDataSource()
private val userService: UserService = InMemoryUserService(dataSource)

@JvmOverloads
fun Application.user(testing: Boolean = false) {
//    installGson()
    routing {
        route("users") {
            get {
                call.respond(userService.findAll())
            }
        }
    }
}