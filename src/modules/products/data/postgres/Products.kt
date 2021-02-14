package com.aditmodhvadia.modules.products.data.postgres

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Products : IntIdTable() {
    val name = varchar("name", 50)
    val price = varchar("price", 50)
    val department = varchar("department", 50)
}

class Product(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Product>(Products)

    var name by Products.name
    var price by Products.price
    var department by Products.department
}