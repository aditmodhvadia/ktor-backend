package com.aditmodhvadia.modules.users.data.postgres

import com.aditmodhvadia.database.postgres.PostgreSqlDatabase.runInDatabase
import com.aditmodhvadia.models.UserDto
import com.aditmodhvadia.modules.users.data.UserDataSource
import java.util.stream.Collectors
import java.util.stream.StreamSupport

class PostgresUserDataSource(private val test: Boolean = false) : UserDataSource {

    private fun User.toDto(): UserDto {
        return UserDto(this.id.value,
            this.firstName,
            this.lastName,
            this.email,
            this.gender,
            this.dateOfBirth,
            this.countryOfBirth)
    }

    override fun retrieveUsers(): Collection<UserDto> {
        return runInDatabase(test) {
            val users = User.all()
            StreamSupport.stream(users.map { it.toDto() }.spliterator(), false).collect(Collectors.toList())
        }
    }
}