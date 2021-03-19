package com.example.intentslearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NEWUSERNAME = "aUsername"
        val EXTRA_NEWPASSWORD = "aPassword"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // test to see if the username came across
        // to "check the mail", we get the Intent that started this Activity by just using intent
        // val lastIntent = intent or val lastIntent = getIntent() is not needed anymore
        // "open the mail" by getting the extra from that intent
        val aUsername = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val aPassword = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        editText_registration_username.setText(aUsername)
        editText_registration_password.setText(aPassword)
        editText_registration_confirmpassword.setText(aPassword)

        Toast.makeText(this, aUsername, Toast.LENGTH_SHORT).show()

        button_registration_submit.setOnClickListener {
            val resultIntent = Intent(this, LoginActivity::class.java).apply {
                putExtra(EXTRA_NEWUSERNAME, aUsername)
                putExtra(EXTRA_NEWPASSWORD, aPassword)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}