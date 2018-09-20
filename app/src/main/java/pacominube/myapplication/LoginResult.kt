package pacominube.myapplication

sealed class LoginResult {
    class InvalidUserName : LoginResult()
    class InvalidPassword : LoginResult()
    class Success : LoginResult()
}