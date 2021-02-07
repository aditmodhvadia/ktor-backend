package com.aditmodhvadia.database.postgres

import com.aditmodhvadia.database.SqlDatabase
import org.jetbrains.exposed.sql.Database

object PostgreSqlDatabase : SqlDatabase {
    override fun connectToDatabase(): Database {
        return Database.connect("jdbc:postgresql://localhost:5433/test", driver = "org.postgresql.Driver",
            user = "postgres", password = "admin")
    }

    override fun connectToTestDatabase(): Database {
        return Database.connect("jdbc:postgresql://localhost:5433/test", driver = "org.postgresql.Driver",
            user = "postgres", password = "admin")
    }
}