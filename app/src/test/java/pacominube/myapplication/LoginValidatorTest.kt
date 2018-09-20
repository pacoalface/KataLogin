package pacominube.myapplication

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.Assert.assertEquals
import org.junit.Test

class LoginValidatorTest {

    private val clock = mock<Clock>()

    private val loginValidator by lazy {
        LoginValidator(clock)
    }

    @Test
    fun loginValidatorShouldReturnFalse() {
        val userName = "pepe"
        val password = "pass"

        val result = loginValidator.validateLogin(userName, password)

        assertEquals(false, result)
    }

    @Test
    fun loginValidatorShouldReturnTrue() {
        val userName = "admin"
        val password = "admin"

        val result = loginValidator.validateLogin(userName, password)

        assertEquals(true, result)
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
