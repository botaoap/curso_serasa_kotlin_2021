package com.serasa.fragmentviewmodel.exempleFragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.exempleFragments.model.ListWhatEver
import com.serasa.fragmentviewmodel.exempleFragments.singleton.ListSingleton

class AdapterToFragment(

) : RecyclerView.Adapter<ItemWhatEverHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemWhatEverHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_whatever,
                parent, false)
        return ItemWhatEverHolder(view)
    }

    override fun onBindViewHolder(holder: ItemWhatEverHolder, position: Int) {
        ListSingleton.listOfWhatEver[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return ListSingleton.listOfWhatEver.size
    }

}

class ItemWhatEverHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(listWe: ListWhatEver) {
        itemView.findViewById<TextView>(R.id.textViewNome).apply {
            text = listWe.nomes
        }
    }
}