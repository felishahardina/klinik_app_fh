package com.example.klinik_app_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // ini dijadikan sebagai splash screen
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //splash screen

        // handle untuk delay selama beberapa detik
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StartScreen2::class.java)
            startActivity(intent)
            finish() //agar ketika dia pindah ke page 2, itu gak back ke splash screen

        }, 3000)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TASK
        //splash screen
        // PADA PAGE START SCREEN 2 --> klik button Get Started akan pindah ke page login
        // page page login, ketika klik tulisan did not have account --> pindah ke page sign up
        // page page sign up, ketika tulisan have account --> pindah ke page login
    }
}