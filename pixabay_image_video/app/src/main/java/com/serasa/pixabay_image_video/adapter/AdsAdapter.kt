package com.serasa.pixabay_image_video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.databinding.ItemAdsBinding

class AdsAdapter : RecyclerView.Adapter<AdsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false).apply {
            return AdsViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 1

}

class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ItemAdsBinding = ItemAdsBinding.bind(itemView)


}