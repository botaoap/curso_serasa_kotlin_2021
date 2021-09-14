package com.serasa.final_resume.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serasa.final_resume.model.Image


class ImageDiffUtilItemCallback : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }
}