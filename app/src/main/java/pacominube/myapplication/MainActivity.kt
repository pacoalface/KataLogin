package pacominube.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val loginValidator = LoginValidator(Clock())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginButton.setOnClickListener {
            if(!loginValidator.validateLogin(userName.text.toString(), password.text.toString())) {
                Toast.makeText(this, "Usuario o contraseña inválidos", Toast.LENGTH_SHORT).show()
            } else {
                it.visibility = View.INVISIBLE
                logoutButton.visibility = View.VISIBLE
                userName.visibility = View.INVISIBLE
                password.visibility = View.INVISIBLE
            }
        }

        logoutButton.setOnClickListener {
           if(loginValidator.validateLogout()) {
               logoutButton.visibility = View.INVISIBLE
               loginButton.visibility = View.VISIBLE
               userName.visibility = View.VISIBLE
               password.visibility = View.VISIBLE
           } else {
               Toast.makeText(this, "Logout error", Toast.LENGTH_SHORT).show()
           }
        }
    }
}
