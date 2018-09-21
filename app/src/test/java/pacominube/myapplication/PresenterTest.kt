package pacominube.myapplication

import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class PresenterTest {

    private val view = mock<Presenter.View>()
    private val loginValidator = mock<LoginValidator>()

    private val presenter by lazy {
        Presenter(loginValidator, view)
    }

    @Test
    fun presenterShouldShowInvalidUsernameMessage() {
        runBlocking {
            whenever(loginValidator.validateLogin(any(), any())).thenReturn(InvalidUserName)

            presenter.login("admin.", "admin")

            verify(view).showError(eq(Presenter.INVALID_USERNAME))
        }
    }

    @Test
    fun presenterShouldShowInvalidPasswordMessage() =
        runBlocking {
            whenever(loginValidator.validateLogin(any(), any())).thenReturn(InvalidPassword)
            presenter.login("admin", "pass")
            verify(view).showError(eq(Presenter.INVALID_PASSWORD))
        }

    @Test
    fun presenterShouldShowLougoutForm() =
        runBlocking {
            whenever(loginValidator.validateLogin(any(), any())).thenReturn(Success)

            presenter.login("admin", "admin")

            verify(view).hideLoginForm()
            verify(view).showLogoutForm()
        }

    @Test
    fun presenterShouldLogout() {
        whenever(loginValidator.validateLogout()).thenReturn(true)

        presenter.logout()

        verify(view).hideLogoutForm()
        verify(view).showLoginForm()
    }

    @Test
    fun presenterShouldShowLogoutError() {
        whenever(loginValidator.validateLogout()).thenReturn(false)

        presenter.logout()

        verify(view).showError(eq(Presenter.LOGOUT_ERROR))
    }
}