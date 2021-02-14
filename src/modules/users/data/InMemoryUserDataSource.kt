package com.aditmodhvadia.modules.users.data

import com.aditmodhvadia.models.UserDto
import java.time.LocalDate

class InMemoryUserDataSource : UserDataSource {
    private val users = mutableListOf(
        UserDto(1,
            "Gerrilee",
            "Gault",
            "ggpault0@edublogs.org",
            "GenderFluid",
            LocalDate.of(2020, 1, 28),
            "United State Of America"),
        UserDto(2,
            "Gerrilee",
            "Gault",
            "ggpault0@edublogs.org",
            "GenderFluid",
            LocalDate.of(2020, 1, 28),
            "United State Of America"),
        UserDto(3,
            "Gerrilee",
            "Gault",
            "ggpault0@edublogs.org",
            "GenderFluid",
            LocalDate.of(2020, 1, 28),
            "United State Of America"),
        UserDto(4,
            "Gerrilee",
            "Gault",
            "ggpault0@edublogs.org",
            "GenderFluid",
            LocalDate.of(2020, 1, 28),
            "United State Of America"),
    )

    override fun retrieveUsers(): Collection<UserDto> = users
}