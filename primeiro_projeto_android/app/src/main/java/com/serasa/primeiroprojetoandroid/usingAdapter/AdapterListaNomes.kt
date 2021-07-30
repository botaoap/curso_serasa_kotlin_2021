package com.serasa.primeiroprojetoandroid.usingAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.primeiroprojetoandroid.R
import org.w3c.dom.Text

class AdapterListaNomes(
    val arrayDeNomes: ArrayList<String>,
    val  onClick: (String, Int) -> Unit
    ) : RecyclerView.Adapter<ViewHolderNomes>() {

    // TODO: Rsponsavel por definir o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNomes {
        // TODO: LayoutInflater é um Singleton
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_nome, parent,
            false)
        return ViewHolderNomes(view)
    }

    // TODO: Responsavel por preencher os campos
    override fun onBindViewHolder(holder: ViewHolderNomes, position: Int) {
        holder.textViewNome.text = arrayDeNomes[position]
        holder.itemView.setOnClickListener{
            onClick(arrayDeNomes[position], position)
        }
    }

    // TODO: Responsavel por contar quantos itens ira retornar
    override fun getItemCount(): Int {
        return arrayDeNomes.size
    }

}

class ViewHolderNomes(itemView : View) : RecyclerView.ViewHolder(itemView){

    val textViewNome: TextView = itemView.findViewById(R.id.nameTextView)
}