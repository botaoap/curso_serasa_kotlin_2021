package com.serasa.crud_db_local_room.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.CategoryFragmentBinding
import com.serasa.crud_db_local_room.databinding.ItemCategoryBinding
import com.serasa.crud_db_local_room.model.Category

class AdapterCategory(var onClick: (Category, deleteImage: View) -> Unit) :
    RecyclerView.Adapter<ItemCategoryViewHolder>() {

    private val listOfCategory = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false).apply {
            return ItemCategoryViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        listOfCategory[position].apply {
            holder.bin(this)
            val image = holder.itemView.findViewById<ImageView>(R.id.imageViewDeleteCategory)
            holder.itemView.setOnClickListener { onClick(this, image) }
        }
    }

    override fun getItemCount(): Int {
        return listOfCategory.size
    }

    fun refresh(newList: List<Category>) {
        listOfCategory.clear()
        listOfCategory.addAll(newList)
        notifyDataSetChanged()
    }
}

class ItemCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding = ItemCategoryBinding.bind(itemView)

    fun bin(category: Category) {
        binding.textViewIdCategory.text = category.id.toString()
        binding.textViewNameCategory.text = category.name
    }
}