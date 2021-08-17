package com.serasa.firebase_with_mvvm.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.serasa.firebase_with_mvvm.R
import com.serasa.firebase_with_mvvm.model.Bill

class AdapterBill : RecyclerView.Adapter<ItemBillViewHolder>(){

    private var listOfBill : MutableList<Bill> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bill, parent, false)
        return ItemBillViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemBillViewHolder, position: Int) {
        listOfBill[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfBill.size
    }

    fun refresh(list : List<Bill>) {
        listOfBill = arrayListOf()
        listOfBill.addAll(list)
        notifyDataSetChanged()
    }
}

class ItemBillViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bind (bill : Bill) {
        setData(bill.uid, R.id.textViewId)
        setData(bill.name, R.id.textViewName)
        setData(bill.price.toString(), R.id.textViewPrice)
    }

    private fun setData(value : String?, @IdRes componentId: Int) {
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }
}