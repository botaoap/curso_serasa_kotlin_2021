package com.serasa.final_resume.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.serasa.final_resume.servie.VideoConfig

class VideoAdapter : ListAdapter<VideoConfig, ItemVideoViewHolder>(VideoDiffUtilItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVideoViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemVideoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class ItemVideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}