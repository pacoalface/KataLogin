package pacominube.myapplication

class LoginValidator(private val clock: Clock) {

    companion object {
        const val CREDENTIALS = "admin"
    }

    fun validateLogin(userName: String, password: String): LoginResult {
        return if (userName == CREDENTIALS && password == CREDENTIALS) Success
        else if (userName.contains(Regex("[.,;]"))) InvalidUserName
        else InvalidPassword
    }

    fun validateLogout(): Boolean {
        return clock.getTimeInMillis() % 2 == 0L
    }
}