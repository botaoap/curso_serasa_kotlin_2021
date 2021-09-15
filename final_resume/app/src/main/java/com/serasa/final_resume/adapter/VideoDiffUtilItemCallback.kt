package com.serasa.final_resume.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serasa.final_resume.servie.VideoConfig

class VideoDiffUtilItemCallback : DiffUtil.ItemCallback<VideoConfig>() {
    override fun areItemsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VideoConfig, newItem: VideoConfig): Boolean {
        return oldItem.id == newItem.id
    }
}