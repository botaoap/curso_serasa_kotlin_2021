package com.serasa.login_serasa.exercicioLoginSerasa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.login_serasa.R
import com.serasa.login_serasa.exercicioLoginSerasa.model.ListaConta
import com.serasa.login_serasa.exercicioLoginSerasa.singleton.ListaContaSingleton

class AdapterLogin(


) : RecyclerView.Adapter<ItemLoginHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLoginHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_contas, parent, false)
        return ItemLoginHolder(view)
    }

    override fun onBindViewHolder(holder: ItemLoginHolder, position: Int) {
        ListaContaSingleton.conta[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return ListaContaSingleton.conta.size
    }

}

class ItemLoginHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(conta : ListaConta){
        itemView.findViewById<TextView>(R.id.texteViewTitleConta).apply {
            text = conta.title
        }
        itemView.findViewById<TextView>(R.id.texteViewValorConta).apply {
            text = conta.valor.toString()
        }
        itemView.findViewById<TextView>(R.id.texteViewDescriptionConta).apply {
            text = conta.description
        }
        itemView.findViewById<ImageView>(R.id.imageViewAvatarContas).apply {
            Glide.with(itemView)
                .load(conta.logo.url)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }
    }
}