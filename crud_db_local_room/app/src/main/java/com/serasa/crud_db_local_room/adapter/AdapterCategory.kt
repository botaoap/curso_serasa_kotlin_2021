package com.serasa.crud_db_local_room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.ItemCategoryBinding
import com.serasa.crud_db_local_room.model.Category

class AdapterCategory(var onClick: (Category, isDelete: Boolean) -> Unit) :
    RecyclerView.Adapter<ItemCategoryViewHolder>() {

    private var listOfCategory = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false).apply {
            return ItemCategoryViewHolder(this, onClick)
        }
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        listOfCategory[position].apply {

            holder.bin(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfCategory.size
    }

    fun refresh(newList: List<Category>) {
        listOfCategory = mutableListOf()
        listOfCategory.addAll(newList)
        notifyDataSetChanged()
    }
}

class ItemCategoryViewHolder(itemView: View, val onClick: (Category, isDelete: Boolean) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    var binding = ItemCategoryBinding.bind(itemView)


    fun bin(category: Category) {
        binding.textViewIdCategory.text = category.id.toString()
        binding.textViewNameCategory.text = category.name
        binding.imageViewDeleteCategory.setColorFilter(itemView.context.getColor(R.color.red))
        binding.imageViewDeleteCategory.setOnClickListener {
            onClick(category, true)
        }
        binding.imageViewUpdateCategory.setOnClickListener {
            onClick(category, false)
        }


    }
}