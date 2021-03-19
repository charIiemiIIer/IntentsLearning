package com.example.intentslearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// import com.example.intentslearning.LoginActivity.Companion.EXTRA_NEWUSERNAME
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*

class LoginActivity : AppCompatActivity() {

    // to access public constants in other classes, we have to put them in a companion object
    companion object {
        val EXTRA_USERNAME = "username" // to help us remember what the key is
        val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // make an onClickListener for the sign up button
        button_login_signup.setOnClickListener {
            // extract the current text in the username box
            val username = editText_login_username.text.toString()
            val password = editText_login_password.text.toString()
            // create an Intent that will launch the Registration Activity
            // the Intent need to know where you are coming from and where you are going
            // FileName::class.java gives you access to the class location for the Intent
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                // store that username in an "extra" in that Intent
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }
                // launch the new Activity
                // startActivity(registrationIntent)
            startActivityForResult(registrationIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var newUsername = editText_registration_username.text.toString()
        var newPassword = editText_registration_password.text.toString()

            if(requestCode == 1) {
                if(resultCode == RESULT_OK) {
                    val username = intent.getStringExtra(RegistrationActivity.EXTRA_NEWUSERNAME)
                    val password = intent.getStringExtra(RegistrationActivity.EXTRA_NEWPASSWORD)
                    editText_login_username.setText(username)
                    editText_login_password.setText(password)
                }
            }
    }
}
