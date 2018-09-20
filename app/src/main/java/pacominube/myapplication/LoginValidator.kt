package pacominube.myapplication

class LoginValidator(private val clock: Clock) {

    companion object {
        const val CREDENTIALS = "admin"
    }

    fun validateLogin(userName: String, password: String): LoginResult {
        return if (userName == CREDENTIALS && password == CREDENTIALS) LoginResult.Success()
        else if (userName.contains(Regex("[.,;]"))) LoginResult.InvalidUserName()
        else LoginResult.InvalidPassword()
    }

    fun validateLogout(): Boolean {
        return clock.getTimeInMillis() % 2 == 0L
    }
}