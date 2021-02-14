package com.aditmodhvadia.database.postgres

import com.aditmodhvadia.database.SqlDatabase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction

object PostgreSqlDatabase : SqlDatabase {
    override fun connectToDatabase(): Database {
        return Database.connect("jdbc:postgresql://localhost:5433/test", driver = "org.postgresql.Driver",
            user = "postgres", password = "admin")
    }

    override fun connectToTestDatabase(): Database {
        return Database.connect("jdbc:postgresql://localhost:5433/test", driver = "org.postgresql.Driver",
            user = "postgres", password = "admin")
    }

    fun <R> runInDatabase(test: Boolean, block: Transaction.() -> R): R {
        if (test) {
            connectToTestDatabase()
        } else {
            connectToDatabase()
        }
        return transaction {
            block()
        }
    }
}