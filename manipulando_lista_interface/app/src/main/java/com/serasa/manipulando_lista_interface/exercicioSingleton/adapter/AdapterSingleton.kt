package com.serasa.manipulando_lista_interface.exercicioSingleton.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.exercicioSingleton.model.LogoProduto
import com.serasa.manipulando_lista_interface.exercicioSingleton.model.ProdutoSingleton
import com.serasa.manipulando_lista_interface.exercicioSingleton.singleton.ListaSingleton

class AdapterSingleton(

    val onCliableSingleton : ClickableSingleton

) : RecyclerView.Adapter<ItemProdutoSingletonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProdutoSingletonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_singleton, parent, false)
        return ItemProdutoSingletonHolder(view)
    }

    override fun onBindViewHolder(holder: ItemProdutoSingletonHolder, position: Int) {
        ListaSingleton.listaProdutos[position].apply {
            holder.bind(this)
            holder.itemView.findViewById<Button>(R.id.ButtonDeleteSingleton).setOnClickListener {
                onCliableSingleton.onDelete(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return ListaSingleton.listaProdutos.size
    }

    fun remove(produtoSingleton: ProdutoSingleton) {
        ListaSingleton.listaProdutos.remove(produtoSingleton)
        notifyDataSetChanged()
    }

    fun refresh() {
        notifyDataSetChanged()
    }
}

class ItemProdutoSingletonHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(produtoSingleton: ProdutoSingleton){
        itemView.findViewById<TextView>(R.id.TextViewNomeSingleton).apply {
            text = produtoSingleton.nome
        }
        itemView.findViewById<TextView>(R.id.TextViewDescriptionSingleton).apply {
            text = produtoSingleton.description
        }
        itemView.findViewById<ImageView>(R.id.ImageViewLogoSingleton).apply {
            Glide.with(itemView)
                .load(produtoSingleton.logo.url)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }

    }
}