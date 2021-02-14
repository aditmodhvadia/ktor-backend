package modules.users.data

import com.aditmodhvadia.modules.users.data.postgres.PostgresUserDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserDataSourceTest {
    private val userDataSource = PostgresUserDataSource()

    @Test
    fun `should retrieve all users`() {
        // when
        val banks = userDataSource.retrieveUsers()

        // then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should get some data`() {
        // when
        val users = userDataSource.retrieveUsers()

        // then
        // ids should be unique
        assertThat(users.map { it.id }.toSet().size).isEqualTo(users.size)
    }
}