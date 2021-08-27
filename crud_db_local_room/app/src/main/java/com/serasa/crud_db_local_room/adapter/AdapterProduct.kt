package com.serasa.crud_db_local_room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.ItemProductBinding
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory

class AdapterProduct(val onClick: (ProductWithCategory, isDelete: Boolean) -> Unit) : RecyclerView.Adapter<ItemProductViewHolder>(){

    private val listOfProduct = mutableListOf<ProductWithCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false).apply {
            return ItemProductViewHolder(this, onClick)
        }
    }

    override fun onBindViewHolder(holder: ItemProductViewHolder, position: Int) {
        listOfProduct[position].apply{
            holder.bin(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfProduct.size
    }

    fun refresh(newList: List<ProductWithCategory>) {
        listOfProduct.clear()
        listOfProduct.addAll(newList)
        notifyDataSetChanged()
    }
}

class ItemProductViewHolder(itemView: View, val onClick: (ProductWithCategory, isDelete: Boolean) -> Unit) : RecyclerView.ViewHolder(itemView) {
    val binding: ItemProductBinding = ItemProductBinding.bind(itemView)

    fun bin(product: ProductWithCategory) {
        binding.textViewIdProduct.text = "ID: ${product.product?.id.toString()}"
        binding.textViewNameProduct.text = product.product?.name
        binding.textViewPriceProduct.text = "R$${product.product?.price.toString()}"
        binding.textViewCategoryOfProduct.text = "Category: ${product.category?.name}"
        binding.imageViewDeleteProduct.setColorFilter(itemView.context.getColor(R.color.red))
        binding.imageViewDeleteProduct.setOnClickListener {
            onClick(product,true)
        }
        binding.imageViewUpdateProduct.setOnClickListener {
            onClick(product, false)
        }
    }
}