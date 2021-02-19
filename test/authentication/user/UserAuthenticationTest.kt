package authentication.user

import com.aditmodhvadia.authentication.user.UserAuthentication
import com.aditmodhvadia.authentication.user.UserAuthenticationPostgres
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class UserAuthenticationTest {
    private val userAuth: UserAuthentication = UserAuthenticationPostgres()

    @Test
    fun `should get user with correct id`() {
        // given
        val userId = 5

        // when
        val user = userAuth.findUserById(userId)

        // then
        assertThat(user).isNotNull
        assertThat(user.id).isEqualTo(userId)
    }

    @ParameterizedTest(name = "No user with id {0}")
    @ValueSource(ints = [0, -1, -100, Int.MAX_VALUE, Int.MIN_VALUE])
    fun `should throw error with incorrect id`(userId: Int) {
        // when/then
        val exception = assertThrows<NoSuchElementException> { userAuth.findUserById(userId) }
        assertThat(exception.message).isEqualTo("User with given id not found")
    }
}