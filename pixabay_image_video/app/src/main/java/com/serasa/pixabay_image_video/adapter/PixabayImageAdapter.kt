package com.serasa.pixabay_image_video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.databinding.ItemImageBinding
import com.serasa.pixabay_image_video.databinding.MainActivityBinding
import com.serasa.pixabay_image_video.databinding.MainFragmentBinding
import com.serasa.pixabay_image_video.model.Image

class PixabayImageAdapter: ListAdapter<Image, ItemPixabayImageViewHolder>(ImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPixabayImageViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false).apply {
            return ItemPixabayImageViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemPixabayImageViewHolder, position: Int) {
        getItem(position).apply {
            holder.bind(this)
        }
    }
}

class ItemPixabayImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemImageBinding.bind(itemView)

    fun bind(image: Image) {
        binding.textViewName.text = image.user
        Glide.with(itemView).load(image.userImageURL).into(binding.imageViewAvatar)
        Glide.with(itemView).load(image.largeImageURL).into(binding.imageViewPhoto)
    }
}