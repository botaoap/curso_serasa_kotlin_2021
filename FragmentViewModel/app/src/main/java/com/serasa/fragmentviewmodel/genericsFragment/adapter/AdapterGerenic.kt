package com.serasa.fragmentviewmodel.genericsFragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.genericsFragment.model.Carro
import com.serasa.fragmentviewmodel.genericsFragment.model.Nome

class AdapterGerenic<T> (val listOf : MutableList<T>): RecyclerView.Adapter<ItemListGenericHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListGenericHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_of_generic,parent,false)
        return ItemListGenericHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListGenericHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOf.size
    }
}

class ItemListGenericHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val idTextView: TextView = itemView.findViewById(R.id.textViewIdGeneric)
    private val nomeTextView: TextView = itemView.findViewById(R.id.textViewNomeGeneric)


    fun <T> bind(genericListNome: T) {
        when(genericListNome) {
            is Nome -> {
                idTextView.text = genericListNome.id.toString()
                nomeTextView.text = genericListNome.nome
            }
            is Carro -> {
                idTextView.text = genericListNome.id.toString()
                nomeTextView.text = genericListNome.modelo
            }
        }
    }

}