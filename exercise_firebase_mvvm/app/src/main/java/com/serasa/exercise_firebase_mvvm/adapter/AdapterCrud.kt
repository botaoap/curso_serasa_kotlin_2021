package com.serasa.exercise_firebase_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.model.Bill

class AdapterCrud(val onClick: (Bill?) -> Unit) : RecyclerView.Adapter<ItemCrudViewHolder>(){

    private var listOfCrud: MutableList<Bill> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCrudViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_crud, parent, false)
        return ItemCrudViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemCrudViewHolder, position: Int) {
        listOfCrud[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener { onClick(this) }
        }
    }

    override fun getItemCount(): Int {
        return listOfCrud.size
    }

    fun refresh(list: List<Bill>) {
        listOfCrud = mutableListOf()
        listOfCrud.addAll(list)
        notifyDataSetChanged()
    }

}

class ItemCrudViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(bill : Bill) {
        setData(bill.uid, R.id.textViewUidCrud)
        setData(bill.name, R.id.textViewNameCrud)
        setData("R$ ${bill.price.toString()}", R.id.textViewPriceCrud)
    }

    fun setData(value: String?, @IdRes componentId: Int) {
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }
}