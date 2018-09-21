package pacominube.myapplication

import co.metalab.asyncawait.async

class Presenter(private val loginValidator: LoginValidator, private val view: View) {

    companion object {
        const val INVALID_USERNAME = "Invalid username"
        const val INVALID_PASSWORD = "Invalid password"
        const val LOGOUT_ERROR = "Logout error"
    }

    fun login(userName: String, password: String) = async {
        val result = loginValidator.validateLogin(userName, password)
        when (result) {
            is InvalidUserName -> view.showError(INVALID_USERNAME)
            is InvalidPassword -> view.showError(INVALID_PASSWORD)
            is Success -> {
                view.hideLoginForm()
                view.showLogoutForm()
            }
        }
    }

    fun logout() = async {
        if (loginValidator.validateLogout()) {
            view.hideLogoutForm()
            view.showLoginForm()
        } else {
            view.showError(LOGOUT_ERROR)
        }
    }

    interface View {
        fun showError(message: String)
        fun showLoginForm()
        fun showLogoutForm()
        fun hideLoginForm()
        fun hideLogoutForm()
    }
}