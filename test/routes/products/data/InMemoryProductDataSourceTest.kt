package routes.products.data

import com.aditmodhvadia.models.Product
import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `should get product with given id`() {
        // given
        val productId = 1L

        // when
        val product = productDataSource.retrieveProduct(productId)

        // then
        assertThat(product).isNotNull
        assertThat(product.id).isEqualTo(productId)
    }

    @Test
    fun `should should throw exception when product with given id not found`() {
        // given
        val productId = -1L

        // when/then
        val exception = assertThrows<NoSuchElementException> { productDataSource.retrieveProduct(productId) }
        assertThat(exception.message).isEqualTo("Product with given id not found")
    }
}