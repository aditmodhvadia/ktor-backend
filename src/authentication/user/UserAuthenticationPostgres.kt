package com.aditmodhvadia.authentication.user

import com.aditmodhvadia.database.postgres.PostgreSqlDatabase.runInDatabase
import com.aditmodhvadia.models.UserDto
import com.aditmodhvadia.modules.users.data.postgres.User

class UserAuthenticationPostgres(private val test: Boolean = false) : UserAuthentication {

    override fun findUserById(id: Int): UserDto {
        return runInDatabase(test) {
            User.findById(id)?.toDto() ?: throw NoSuchElementException("User with given id not found")
        }
    }
}