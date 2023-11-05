package com.example.fakewalmart.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.fakewalmart.R
import com.example.fakewalmart.model.User

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_category)
        val receivedObject = intent.getParcelableExtra<User>("LOGIN_DATA")
        var electronicImg = findViewById<ImageView>(R.id.electronicsImg)
        var clothingImg = findViewById<ImageView>(R.id.clothingImg)
        var beautyImg = findViewById<ImageView>(R.id.beautyImg)
        var foodImg = findViewById<ImageView>(R.id.foodImg)
        var welcomeTxt = findViewById<TextView>(R.id.welcomeTxt)

        var userFullName = receivedObject?.firstName + " " + receivedObject?.lastName
        var welcomeStr = "Welcome, " + userFullName

        welcomeTxt.setText(welcomeStr)

        electronicImg.setOnClickListener {
            Toast.makeText(this, "Electronics Category clicked", Toast.LENGTH_SHORT).show()
        }

        clothingImg.setOnClickListener {
            Toast.makeText(this, "Clothing Category clicked", Toast.LENGTH_SHORT).show()
        }

        beautyImg.setOnClickListener {
            Toast.makeText(this, "Beauty Category clicked", Toast.LENGTH_SHORT).show()
        }

        foodImg.setOnClickListener {
            Toast.makeText(this, "Food Category clicked", Toast.LENGTH_SHORT).show()
        }
    }
}