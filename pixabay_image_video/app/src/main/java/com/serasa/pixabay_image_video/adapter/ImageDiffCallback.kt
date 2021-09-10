package com.serasa.pixabay_image_video.adapter


import androidx.recyclerview.widget.DiffUtil
import com.serasa.pixabay_image_video.model.Image

open class ImageDiffCallback(
    private val oldList: List<Image>,
    private val newList: List<Image>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}