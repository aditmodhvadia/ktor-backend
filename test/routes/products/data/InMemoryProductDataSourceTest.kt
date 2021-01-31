package routes.products.data

import com.aditmodhvadia.models.Product
import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InMemoryProductDataSourceTest {
    private val productDataSource = InMemoryProductDataSource()

    @Test
    fun `should retrieve all products`() {

        // when
        val products: Collection<Product> = productDataSource.retrieveProducts()

        // then
        assertThat(products.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should get some data`() {
        // when
        val products = productDataSource.retrieveProducts()

        // then
        assertThat(products.map { it.id }.toSet().size).isEqualTo(products.size)
    }

}