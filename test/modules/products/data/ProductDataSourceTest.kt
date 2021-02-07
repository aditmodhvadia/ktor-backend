package modules.products.data

import com.aditmodhvadia.models.ProductDto
import com.aditmodhvadia.modules.products.data.postgres.PostgresProductDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ProductDataSourceTest {
    private val productDataSource = PostgresProductDataSource(test = true)

    @Test
    fun `should retrieve all products`() {

        // when
        val products: Collection<ProductDto> = productDataSource.retrieveProducts()

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

    @ParameterizedTest(name = "Product with id {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `should get product with given id`(productId: Int) {
        // when
        val product = productDataSource.retrieveProduct(productId)

        // then
        assertThat(product).isNotNull
        assertThat(product.id).isEqualTo(productId)
    }

    @ParameterizedTest(name = "No product with id {0}")
    @ValueSource(ints = [0, -1, -100, Int.MAX_VALUE, Int.MIN_VALUE])
    fun `should should throw exception when product with given id not found`(productId: Int) {
        // when/then
        val exception = assertThrows<NoSuchElementException> { productDataSource.retrieveProduct(productId) }
        assertThat(exception.message).isEqualTo("Product with given id not found")
    }
}