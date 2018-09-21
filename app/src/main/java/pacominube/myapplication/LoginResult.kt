package pacominube.myapplication

sealed class LoginResult
object InvalidUserName : LoginResult()
object InvalidPassword : LoginResult()
object Success : LoginResult()