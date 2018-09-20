package pacominube.myapplication

import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test


class PresenterTest {

    private val view = mock<Presenter.View>()
    private val loginValidator = mock<LoginValidator>()

    private val presenter by lazy {
        Presenter(loginValidator)
    }

    @Before
    fun setup() {
        presenter.attachView(view)
    }

    @Test
    fun presenterShouldShowInvalidUsernameMessage() {
        whenever(loginValidator.validateLogin(any(), any())).thenReturn(LoginResult.InvalidUserName())

        presenter.login("admin.", "admin")

        verify(view).showError(eq(Presenter.INVALID_USERNAME))
    }

    @Test
    fun presenterShouldShowInvalidPasswordMessage() {
        whenever(loginValidator.validateLogin(any(), any())).thenReturn(LoginResult.InvalidPassword())

        presenter.login("admin", "pass")

        verify(view).showError(eq(Presenter.INVALID_PASSWORD))
    }

    @Test
    fun presenterShouldShowLougoutForm() {
        whenever(loginValidator.validateLogin(any(), any())).thenReturn(LoginResult.Success())

        presenter.login("admin", "pass")

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