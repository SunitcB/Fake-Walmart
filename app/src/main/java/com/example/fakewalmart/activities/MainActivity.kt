package com.example.fakewalmart.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.fakewalmart.R
import com.example.fakewalmart.model.User
import com.google.android.material.textfield.TextInputLayout
import java.util.Objects

class MainActivity : AppCompatActivity() {
    val usersArray = arrayListOf<User>(
        User("Sunit", "Bajracharya", "sunit.bajracharya@gmail.com", "mypassword"),
        User("aaaa", "111111", "aaaa.111111@gmail.com", "password123"),
        User("bbbb", "222222", "bbbb.222222@gmail.com", "password123"),
        User("cccc", "333333", "cccc.333333@gmail.com", "password123"),
        User("dddd", "444444", "dddd.444444@gmail.com", "password123")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var receivedObject = intent.getParcelableExtra<User>("NEW_USER")
        if (Objects.nonNull(receivedObject)) {
            if (receivedObject != null) {
                usersArray.add(receivedObject)
                Toast.makeText(this, "New user has been created successfully.", Toast.LENGTH_SHORT).show()
            }
        }
        var signInBtn = findViewById<Button>(R.id.signInBtn)
        var signUpBtn = findViewById<Button>(R.id.signUpBtn)
        var usernameTxt = findViewById<TextInputLayout>(R.id.usernameTxt)
        var passwordTxt = findViewById<TextInputLayout>(R.id.passwordTxt)
        var forgotPassword = findViewById<TextView>(R.id.forgotPasswordLink)

        signUpBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener {
            var username = usernameTxt.editText?.text.toString()
            if (username.isEmpty()) {
                Toast.makeText(
                    this,
                    "Put down the username for the password look up",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                var userObj = usersArray.find { user ->
                    user.username.equals(username)
                }
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.type = "message/rfc822"
                emailIntent.putExtra(Intent.EXTRA_EMAIL, username)
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your forgotten password")
                emailIntent.putExtra(Intent.EXTRA_TEXT, userObj?.password)
                startActivity(Intent.createChooser(emailIntent, "Your forgotten password"))
            }
        }

        signInBtn.setOnClickListener {
            val intent = Intent(this, ShoppingCategory::class.java)
            var username = usernameTxt.editText?.text.toString()
            var password = passwordTxt.editText?.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username and Password are required.", Toast.LENGTH_SHORT)
                    .show()
            }

            var userObj = usersArray.find { user ->
                user.username.equals(username) && user.password.equals(
                    password
                )
            }

            if (Objects.nonNull(userObj)) {
                intent.putExtra("LOGIN_DATA", userObj)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username or Password is incorrect.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}