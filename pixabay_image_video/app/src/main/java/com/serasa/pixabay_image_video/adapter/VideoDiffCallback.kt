package com.serasa.pixabay_image_video.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serasa.pixabay_image_video.model.VideoConfig

class VideoDiffCallback : DiffUtil.ItemCallback<VideoConfig>() {
    override fun areItemsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem.id == newItem.id
    }


}