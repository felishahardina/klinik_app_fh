package com.example.klinik_app_kotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.klinik_app_kotlin.DetailDoctor
import com.example.klinik_app_kotlin.R
import com.example.klinik_app_kotlin.model.ModelListDoctors
import com.example.klinik_app_kotlin.screen.HomeDoctorsActivity


class ListDoctorsAdapter (
    val getDetailDoctors: HomeDoctorsActivity,
    val itemDoctorList: List<ModelListDoctors>
) :
    RecyclerView.Adapter<ListDoctorsAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemDoctor : ImageView = itemView.findViewById(R.id.imgDetailItemDoctor)
        var txtNamaDoctor : TextView = itemView.findViewById(R.id.txtDetailNamaDoctor)
        var txtSpesDoctor : TextView = itemView.findViewById(R.id.txtDetailSpesDoctor)
        var txtReviewDoctor : TextView = itemView.findViewById(R.id.txtDetailReviewDoctor)
        var txtJumlahRating : TextView = itemView.findViewById(R.id.txtDetailJumlahRating)
        val cardKlinik : CardView = itemView.findViewById(R.id.CardDoctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_doctors, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.imgItemDoctor.setImageResource(currentItem.ImgDoctor)
        holder.txtNamaDoctor.text = currentItem.NamaDoctor
        holder.txtSpesDoctor.text = currentItem.SpesDoctor
        holder.txtReviewDoctor.text = currentItem.JumlahReview
        holder.txtJumlahRating.text = currentItem.JumlahRating

        holder.cardKlinik.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getDetailDoctors, DetailDoctor::class.java)
            //put extra
            intent.putExtra("Image Doctor", itemDoctorList[position].ImgDoctor)
            intent.putExtra("Nama Doctor", itemDoctorList[position].NamaDoctor)
            intent.putExtra("Spes Doctor", itemDoctorList[position].SpesDoctor)
            intent.putExtra("Jumlah Review", itemDoctorList[position].JumlahReview)
            intent.putExtra("Jumlah Rating", itemDoctorList[position].JumlahRating)

            //intent.putExtra("judul",itemList[position].judul)
            // start pindah ke detail
            getDetailDoctors.startActivity(intent)

            Toast.makeText(getDetailDoctors,itemDoctorList[position].NamaDoctor, Toast.LENGTH_SHORT).show()
        }
    }
}