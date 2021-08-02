package com.serasa.projeto_segunda_semana.usingAdapterForList

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.projeto_segunda_semana.R
import com.serasa.projeto_segunda_semana.model.Car

class AdapterRecyclerView(
    val listOfCars: List<Car>
): RecyclerView.Adapter<ItemCarViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ItemCarViewHolder(view)
    }

    // TODO: Responsavel por preencher os campos
    override fun onBindViewHolder(holder: ItemCarViewHolder, position: Int) {
        listOfCars[position].apply {
            holder.bind(this)
        }


    }

    override fun getItemCount(): Int {
        return listOfCars.size
    }

}

class ItemCarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // TODO: cria uma linha toda vez que receber um valor
    fun bind(car : Car) {
        itemView.findViewById<TextView>(R.id.textMarcaCarDescription).apply {
            text = car.marca
        }
        itemView.findViewById<TextView>(R.id.textModeloCarDescription).apply {
            text = car.modelo
        }
        itemView.findViewById<TextView>(R.id.textAnoCarDescription).apply {
            text = car.ano.toString()
        }
        itemView.findViewById<ImageView>(R.id.imageCarAvatar).apply {
             Glide.with(itemView).load(car.url).into(this)
        }

    }



}