package com.serasa.manipulando_lista_interface.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.model.ListTodo

class AdapterListTodo(
    val listOfTodo: MutableList<ListTodo>,
    val onClickable: ClickableList
) : RecyclerView.Adapter<ItemListTodoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListTodoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemListTodoHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListTodoHolder, position: Int) {
        listOfTodo[position].apply {
            holder.bind(this)
            holder.itemView.findViewById<Button>(R.id.editButton).setOnClickListener {
                onClickable.onEdit(this)
            }
            holder.itemView.findViewById<Button>(R.id.deletetButton).setOnClickListener {
                onClickable.onDelete(this)
            }
            holder.itemView.findViewById<Button>(R.id.addButton).setOnClickListener {
                onClickable.onAdd(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfTodo.size
    }

    fun removeTodo(todo: ListTodo) {
        listOfTodo.remove(todo)
        notifyDataSetChanged()
    }

    fun add(todo: ListTodo) {
        listOfTodo.add(todo)
        notifyDataSetChanged()
    }


}

class ItemListTodoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(todo: ListTodo) {
        itemView.findViewById<TextView>(R.id.titleTextView).apply {
            text = todo.title
        }
        itemView.findViewById<TextView>(R.id.descriptionTextView).apply {
            text = todo.description
        }
        itemView.findViewById<ImageView>(R.id.imageAvatarList).apply {
            Glide.with(itemView)
                .load(todo.logo.url)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }
    }
}