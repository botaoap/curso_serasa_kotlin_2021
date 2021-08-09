package com.serasa.login_serasa.loginConsumindoApiWithToken

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products

class AdapterRecyclerViewListOfProducts(
    var listOfProduct :  MutableList<Products>
) : RecyclerView.Adapter<ItemListOfProductsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListOfProductsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista_api_products, parent, false)
        return ItemListOfProductsHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListOfProductsHolder, position: Int) {
        listOfProduct[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfProduct.size
    }

    fun refreshList(listProduct: List<Products>){
        listOfProduct = mutableListOf()
        listOfProduct.addAll(listProduct)
        notifyDataSetChanged()

    }

}

class ItemListOfProductsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(product : Products) {
        itemView.findViewById<TextView>(R.id.textViewTitleProduct).apply {
            text = product.title
        }
        itemView.findViewById<TextView>(R.id.textViewCategoryProduct).apply {
            text = product.category
        }
        itemView.findViewById<TextView>(R.id.textViewDescriptionProduct).apply {
            text = product.description
        }
        itemView.findViewById<TextView>(R.id.textViewPriceProduct).apply {
            text = "R$ ${product.price.toString()}"
        }
        itemView.findViewById<ImageView>(R.id.imageViewAvatarProduct).apply {
            Glide.with(itemView)
                .load(product.image)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }
    }
}