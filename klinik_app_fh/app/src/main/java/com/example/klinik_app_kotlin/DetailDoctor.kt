package com.example.klinik_app_kotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.klinik_app_kotlin.R

class DetailDoctor : AppCompatActivity() {

    private lateinit var imageDetailDoctor : ImageView
    private lateinit var txtDetailNamaDoctor : TextView
    private lateinit var txtDetailSpesDoctor : TextView
    private lateinit var txtDetailJumlahReview: TextView
    private lateinit var detailRating : RatingBar
    private lateinit var txtDetailJumlahRating: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctor)

        imageDetailDoctor = findViewById(R.id.imgDetailItemDoctor)
        txtDetailNamaDoctor = findViewById(R.id.txtDetailNamaDoctor)
        txtDetailSpesDoctor = findViewById(R.id.txtDetailSpesDoctor)
        txtDetailJumlahReview = findViewById(R.id.txtDetailReviewDoctor)
        detailRating = findViewById(R.id.ratingBarDetail)
        txtDetailJumlahRating = findViewById(R.id.txtDetailJumlahRating)


        //get data
        val imgDoctor = intent.getIntExtra("Image Doctor", 0)
        val namaDoctor = intent.getStringExtra("Nama Doctor")
        val spesDoctor = intent.getStringExtra("Spes Doctor")
        val jumlahReview = intent.getStringExtra("Jumlah Review")
        val jumlahRating = intent.getStringExtra("Jumlah Rating")

        //set data ke widget
        imageDetailDoctor.setImageResource(imgDoctor)
        txtDetailNamaDoctor.setText(namaDoctor)
        txtDetailSpesDoctor.setText(spesDoctor)
        txtDetailJumlahReview.setText(jumlahReview)
        txtDetailJumlahRating.setText(jumlahRating)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}