package com.example.klinik_app_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageSignUp : AppCompatActivity() {

    private lateinit var txtSignIn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_sign_up)

        txtSignIn = findViewById(R.id.txtSignIn)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtSignIn.setOnClickListener() {
            val intentPassingData = Intent(
                this@PageSignUp,
                PageLogin::class.java
            )
            startActivity(intentPassingData)
        }
    }
}