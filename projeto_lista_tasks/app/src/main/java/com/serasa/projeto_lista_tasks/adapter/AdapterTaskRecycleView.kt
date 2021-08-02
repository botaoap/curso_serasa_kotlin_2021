package com.serasa.projeto_lista_tasks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.projeto_lista_tasks.R
import com.serasa.projeto_lista_tasks.model.Task

class AdapterTaskRecycleView(
    val listOfTask: MutableList<Task>,
    val onClick: (Task) -> Unit
): RecyclerView.Adapter<ItemTaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_tasks, parent, false)
        return ItemTaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemTaskViewHolder, position: Int) {
        listOfTask[position].apply {
            holder.bind(this)
            holder.itemView.findViewById<Button>(R.id.buttonEditar).setOnClickListener {
                onClick(this)
            }
            holder.itemView.findViewById<Button>(R.id.buttonExcluir).setOnClickListener {
                removerTask(this)
            }
//            holder.itemView.findViewById<Button>(R.id.buttonAddNewTask).setOnClickListener {
//                add(this)
//            }
        }
    }

    override fun getItemCount(): Int {
        return listOfTask.size
    }

    fun removerTask(task: Task) {
        listOfTask.remove(task)
        notifyDataSetChanged()
    }

    fun add(task: Task) {
        listOfTask.add(task)
        notifyDataSetChanged()
    }


}

class ItemTaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(task: Task){
        itemView.findViewById<TextView>(R.id.textNomeTarefa).apply {
            text = task.nomeTask
        }
        itemView.findViewById<TextView>(R.id.textDescription).apply {
            text = task.descritionTask
        }
        itemView.findViewById<ImageView>(R.id.imageAvatarTask).apply {
            Glide.with(itemView)
                .load(task.logo.url)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }
    }
}