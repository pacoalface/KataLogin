package pacominube.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Presenter.View {

    private val loginValidator = LoginValidator(Clock())
    private val presenter by lazy {
        Presenter(loginValidator, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            presenter.login(userName.text.toString(), password.text.toString())
        }

        logoutButton.setOnClickListener {
            presenter.logout()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginForm() {
        loginButton.visibility = View.VISIBLE
        userName.visibility = View.VISIBLE
        password.visibility = View.VISIBLE
    }

    override fun showLogoutForm() {
        logoutButton.visibility = View.VISIBLE
    }

    override fun hideLoginForm() {
        userName.visibility = View.INVISIBLE
        password.visibility = View.INVISIBLE
        loginButton.visibility = View.INVISIBLE
    }

    override fun hideLogoutForm() {
        logoutButton.visibility = View.INVISIBLE
    }
}
