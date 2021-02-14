package com.aditmodhvadia.database

import org.jetbrains.exposed.sql.Database

interface SqlDatabase {
    fun connectToDatabase(): Database
    fun connectToTestDatabase(): Database
}