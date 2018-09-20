package pacominube.myapplication

class LoginValidator(private val clock: Clock) {

    companion object {
        const val CREDENTIALS = "admin"
    }

    fun validateLogin(userName: String, password: String) : Boolean {
        return userName == CREDENTIALS && password == CREDENTIALS && !userName.contains(Regex(",.;"))
    }

    fun validateLogout() : Boolean {
        return clock.getTimeInMillis() % 2 == 0L
    }
}