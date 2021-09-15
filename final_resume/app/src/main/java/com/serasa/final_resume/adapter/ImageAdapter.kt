package com.serasa.final_resume.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.ItemImageBinding
import com.serasa.final_resume.model.Image

class ImageAdapter : ListAdapter<Image, ItemImageViewHolder>(ImageDiffUtilItemCallback()) {

    private var listOfImage = mutableListOf<Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemImageViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false).apply {
            return ItemImageViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemImageViewHolder, position: Int) {
        getItem(position).let { image ->
            holder.bind(image)
        }
    }

    fun refresh(newList: List<Image>, clear: Boolean = false) {
        if (clear) {
            listOfImage.clear()
        }
        listOfImage.addAll(newList)
        submitList(listOfImage.toMutableList())
    }
}

class ItemImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemImageBinding.bind(itemView)

    fun bind(image: Image) {
        Glide.with(itemView.context)
            .load(image.webformatURL)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewFeed)
    }
}