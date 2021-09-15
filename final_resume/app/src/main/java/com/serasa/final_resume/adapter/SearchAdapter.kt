package com.serasa.final_resume.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.ItemSearchBinding

class SearchAdapter(val onTyping: (String) -> Unit): RecyclerView.Adapter<ItemSearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSearchViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false).apply {
            return ItemSearchViewHolder(this, onTyping)
        }
    }

    override fun onBindViewHolder(holder: ItemSearchViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1
}

class ItemSearchViewHolder(itemView: View, val onTyping: (String) -> Unit): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemSearchBinding.bind(itemView)

    fun bind() {
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 2) {
                        onTyping(it.toString())
                    }
                    if (it.isEmpty()) {
                        onTyping(it.toString())
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}