package pacominube.myapplication

import junit.framework.Assert.assertEquals
import org.junit.Test

class LoginValidatorTest {
    private val loginValidator by lazy {
        LoginValidator()
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
}
