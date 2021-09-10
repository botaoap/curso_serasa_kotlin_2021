package com.serasa.pixabay_image_video.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.databinding.ItemSearchBinding

class SearchAdapter(val onTyping: (String) -> Unit): RecyclerView.Adapter<ItemSearchAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSearchAdapterViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false).apply {
            return ItemSearchAdapterViewHolder(this, onTyping)
        }
    }

    override fun onBindViewHolder(holder: ItemSearchAdapterViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1
}

class ItemSearchAdapterViewHolder(itemView: View, val onTyping: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSearchBinding.bind(itemView)

    fun bind() {
        binding.ediTextSearchOnHeader.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 1) {
                        onTyping.toString()
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
}