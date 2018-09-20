package pacominube.myapplication

class LoginValidator {

    companion object {
        const val CREDENTIALS = "admin"
    }

    fun validateLogin(userName: String, password: String) : Boolean {
        return userName == CREDENTIALS && password == CREDENTIALS
    }
}