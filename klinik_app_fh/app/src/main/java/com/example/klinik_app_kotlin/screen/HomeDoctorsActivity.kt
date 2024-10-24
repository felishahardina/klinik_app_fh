package com.example.klinik_app_kotlin.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klinik_app_kotlin.R
import com.example.klinik_app_kotlin.adapter.ListDoctorsAdapter
import com.example.klinik_app_kotlin.model.ModelListDoctors
import java.util.ArrayList

class HomeDoctorsActivity : AppCompatActivity() {

    private var rv_list_doctors : RecyclerView? = null
    private var homeDoctorsAdapter : ListDoctorsAdapter? = null

    //array data doctors
    private var doctorsList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctors)

        rv_list_doctors = findViewById(R.id.rv_list_doctor)
        doctorsList = ArrayList()
        homeDoctorsAdapter = ListDoctorsAdapter(this, doctorsList);
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 1)

        rv_list_doctors!!.layoutManager = layoutManager
        rv_list_doctors!!.adapter = homeDoctorsAdapter

        //create dummy data
        prepareDataDoctors()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareDataDoctors(){
        var itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            "Salti Dilfani",
            "nana",
            "140",
            "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter6,
            "Felisha Hardina",
            "caca",
            "100",
            "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter3,
            "Humaira Elfi Putri",
            "umay",
            "130",
            "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter4,
            "Oryza Conseva",
            "izaa",
            "120",
            "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter5,
            "Calista Monica Alfi",
            "tata",
            "150",
            "5.0"
        )
        doctorsList.add(itemDoctors)
        homeDoctorsAdapter!!.notifyDataSetChanged()
    }
}