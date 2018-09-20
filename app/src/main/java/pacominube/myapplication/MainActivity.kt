package pacominube.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginValidator = LoginValidator()

        loginButton.setOnClickListener {
            if(!loginValidator.validateLogin(userName.text.toString(), password.text.toString())) {
                Toast.makeText(this, "Usuario o contraseña inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
