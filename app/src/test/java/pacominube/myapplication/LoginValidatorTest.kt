package pacominube.myapplication

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class LoginValidatorTest {

    private val clock = mock<Clock>()

    private val loginValidator by lazy {
        LoginValidator(clock)
    }

    @Test
    fun loginValidatorShouldReturnInvalidCredentials() {
        val userName = "admin"
        val password = "pass"

        val result = loginValidator.validateLogin(userName, password)

        assertTrue(result is LoginResult.InvalidPassword)
    }

    @Test
    fun loginValidatorShouldReturnSuccess() {
        val userName = "admin"
        val password = "admin"

        val result = loginValidator.validateLogin(userName, password)

        assertTrue(result is LoginResult.Success)
    }

    @Test
    fun loginValidatorShouldReturnInvalidUserName() {
        val userName = "admin."
        val password = "admin"

        val result = loginValidator.validateLogin(userName, password)

        assertTrue(result is LoginResult.InvalidUserName)
    }

    @Test fun logoutValidatorShouldReturnTrue() {
        whenever(clock.getTimeInMillis()).thenReturn(2)

        assertEquals(true, loginValidator.validateLogout())
    }

    @Test fun logoutValidatorShouldReturnFalse() {
        whenever(clock.getTimeInMillis()).thenReturn(3)

        assertEquals(false, loginValidator.validateLogout())
    }
}
