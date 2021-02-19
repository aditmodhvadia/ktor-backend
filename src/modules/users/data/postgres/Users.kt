package com.aditmodhvadia.modules.users.data.postgres

import com.aditmodhvadia.models.UserDto
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.date

object Users : IntIdTable() {
    val firstName = varchar("first_name", 150)
    val lastName = varchar("last_name", 150)
    val email = varchar("email", 150)
    val gender = varchar("gender", 50)
    val dateOfBirth = date("date_of_birth")
    val countryOfBirth = varchar("country_of_birth", 90)
    val password = varchar("password", 50)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var firstName by Users.firstName
    var lastName by Users.lastName
    var email by Users.email
    var gender by Users.gender
    var dateOfBirth by Users.dateOfBirth
    var countryOfBirth by Users.countryOfBirth
    var password by Users.password

    fun toDto(): UserDto {
        return UserDto(this.id.value,
            this.firstName,
            this.lastName,
            this.email,
            this.gender,
            this.dateOfBirth,
            this.countryOfBirth)
    }
}