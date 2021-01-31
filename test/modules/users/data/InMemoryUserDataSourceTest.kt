package modules.users.data

import com.aditmodhvadia.routes.users.data.InMemoryUserDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InMemoryUserDataSourceTest {
    private val inMemoryDataSource = InMemoryUserDataSource()

    @Test
    fun `should retrieve all users`() {
        // when
        val banks = inMemoryDataSource.retrieveUsers()

        // then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should get some data`() {
        // when
        val users = inMemoryDataSource.retrieveUsers()

        // then
        assertThat(users.map { it.id }.toSet().size).isEqualTo(users.size)
    }
}