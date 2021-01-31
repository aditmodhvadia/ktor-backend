package routes.users.data

import com.aditmodhvadia.routes.products.data.InMemoryProductDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InMemoryUserDataSourceTest {
    private val inMemoryDataSource = InMemoryProductDataSource()

    @Test
    fun `should retrieve all users`() {
        // when
        val banks = inMemoryDataSource.retrieveProducts()

        // then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should get some data`() {
        // given


        // when
        val users = inMemoryDataSource.retrieveProducts()

        // then
        assertThat(users.map { it.id }.toSet().size).isEqualTo(users.size)
    }
}