package com.serasa.pixabay_image_video.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.databinding.ItemVideoBinding
import com.serasa.pixabay_image_video.model.VideoConfig

class PixabayVideoAdapter: ListAdapter<VideoConfig, ItemPixabayVideoViewHolder>(VideoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPixabayVideoViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false).apply {
            return ItemPixabayVideoViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemPixabayVideoViewHolder, position: Int) {
        getItem(position).let { video ->
            holder.bind(video)
        }
    }
}

class ItemPixabayVideoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemVideoBinding.bind(itemView)

    fun bind(video: VideoConfig) {
        binding.textViewName.text = video.user
        Glide.with(itemView).load(video.userImageURL).into(binding.imageViewAvatar)
        binding.videoView.setVideoURI(Uri.parse(video.videos.medium.url))
        binding.videoView.start()
        binding.videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
            val screenRatio = binding.videoView.width / binding.videoView.height.toFloat()
            val scaleX = videoRatio / screenRatio
            if (scaleX >= 1f) {
                binding.videoView.scaleX = scaleX
            } else {
                binding.videoView.scaleY = 1f / scaleX
            }
        }
    }
}