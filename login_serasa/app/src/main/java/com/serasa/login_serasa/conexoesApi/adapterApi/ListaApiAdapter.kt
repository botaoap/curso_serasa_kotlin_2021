package com.serasa.login_serasa.conexoesApi.adapterApi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.conexoesApi.dataClassApi.OutApi

class ListaApiAdapter(

    var listOfApi: MutableList<OutApi>

) : RecyclerView.Adapter<ItemListaApiHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListaApiHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_api, parent, false)
        return ItemListaApiHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListaApiHolder, position: Int) {
        listOfApi[position].apply{
            holder.bind(this)

        }
    }

    override fun getItemCount(): Int {
        return listOfApi.size
    }

    fun atualizarLista(list : List<OutApi>) {
        listOfApi = mutableListOf()
        listOfApi.addAll(list)
        notifyDataSetChanged()
    }
}

class ItemListaApiHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(apilist : OutApi){
        itemView.findViewById<TextView>(R.id.textViewCodeApi).apply {
            text = apilist.code.toString()
        }
        itemView.findViewById<TextView>(R.id.textViewNomeApi).apply {
            text = apilist.name
        }
    }
}