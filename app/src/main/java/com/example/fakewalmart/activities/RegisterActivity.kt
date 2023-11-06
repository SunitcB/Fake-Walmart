package com.example.fakewalmart.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.fakewalmart.R
import com.example.fakewalmart.model.User
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var firstNameTxt = findViewById<TextInputLayout>(R.id.firstNameTxt)
        var lastNameTxt = findViewById<TextInputLayout>(R.id.lastNameTxt)
        var emailTxt = findViewById<TextInputLayout>(R.id.emailTxt)
        var passwordTxt = findViewById<TextInputLayout>(R.id.passwordTxt)
        var createBtn = findViewById<Button>(R.id.createAccountBtn)

        createBtn.setOnClickListener {
            var firstName = firstNameTxt.editText?.text.toString()
            var lastName = lastNameTxt.editText?.text.toString()
            var emailAddress = emailTxt.editText?.text.toString()
            var password = passwordTxt.editText?.text.toString()
            if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter the required fields", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var newUserObj = User(firstName, lastName, emailAddress, password)
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("NEW_USER", newUserObj)
                startActivity(intent)
            }
        }
    }
}