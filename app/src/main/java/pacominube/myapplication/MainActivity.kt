package pacominube.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val CREDENTIALS = "admin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            if(userName.text.toString() != CREDENTIALS || password.text.toString() != CREDENTIALS) {
                Toast.makeText(this, "Usuario o contraseña inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
