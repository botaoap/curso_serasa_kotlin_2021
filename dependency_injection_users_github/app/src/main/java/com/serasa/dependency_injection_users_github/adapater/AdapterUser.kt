package com.serasa.dependency_injection_users_github.adapater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serasa.dependency_injection_users_github.R
import com.serasa.dependency_injection_users_github.databinding.ItemUsersBinding
import com.serasa.dependency_injection_users_github.model.User

class AdapterUser : RecyclerView.Adapter<ItemUserViewHolder>(){

    private val listOfUser = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUserViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false).apply {
            return ItemUserViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ItemUserViewHolder, position: Int) {
        listOfUser[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfUser.size
    }

    fun refresh(newlist : List<User>) {
        listOfUser.addAll(newlist)
        notifyDataSetChanged()
    }
}

class ItemUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUsersBinding.bind(itemView)

    fun bind(user: User) {
        binding.textViewIdUser.text = user.id.toString()
        binding.textViewNameUser.text = user.login
        binding.imageViewAvatarUser.apply {
            Glide.with(itemView)
                .load(user.image)
                .into(this)
        }

    }
}