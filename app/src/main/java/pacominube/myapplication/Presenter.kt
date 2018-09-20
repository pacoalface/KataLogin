package pacominube.myapplication

class Presenter(private val loginValidator: LoginValidator) {

    companion object {
        const val INVALID_USERNAME = "Invalid username"
        const val INVALID_PASSWORD = "Invalid password"
        const val LOGOUT_ERROR = "Logout error"
    }

    private lateinit var view: View

    fun attachView(view: View) {
        this.view = view
    }

    fun login(userName: String, password: String) {
        when(loginValidator.validateLogin(userName, password)){
            is LoginResult.InvalidUserName -> view.showError(INVALID_USERNAME)
            is LoginResult.InvalidPassword -> view.showError(INVALID_PASSWORD)
            is LoginResult.Success -> {
                view.hideLoginForm()
                view.showLogoutForm()
            }
        }
    }

    fun logout() {
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