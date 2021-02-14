package com.aditmodhvadia.models

import java.time.LocalDate

data class UserDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String?,
    val gender: String,
    val dateOfBirth: LocalDate,
    val countryOfBirth: String,
)
