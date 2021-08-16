package com.serasa.architecture_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.architecture_mvvm.R
import com.serasa.architecture_mvvm.model.Article


class AdapterArticle(val onClick: (Article) -> Unit) : RecyclerView.Adapter<ItemArticleViewHolder>(){

    private var listOfArticle : MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ItemArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemArticleViewHolder, position: Int) {
        listOfArticle[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onClick(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfArticle.size
    }

    fun refresh(list : List<Article>) {
        listOfArticle = mutableListOf()
        listOfArticle.addAll(list)
        notifyDataSetChanged()
    }
}

class ItemArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bind(article : Article) {
        itemView.findViewById<TextView>(R.id.textViewTitle).apply {
            text = article.title
        }
        itemView.findViewById<TextView>(R.id.textViewNewsSite).apply {
            text = article.newsSite
        }
        itemView.findViewById<ImageView>(R.id.imageViewArticle).apply {
            Glide.with(context)
                .load(article.image)
                .placeholder(R.drawable.ic_gmailerrorred)
                .into(this)
        }
    }
}