package com.serasa.pixabay_image_video.adapter


import androidx.recyclerview.widget.DiffUtil
import com.serasa.pixabay_image_video.model.Image

open class ImageDiffCallback(
): DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }

}