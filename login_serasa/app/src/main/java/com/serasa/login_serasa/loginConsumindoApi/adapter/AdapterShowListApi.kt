package com.serasa.login_serasa.loginConsumindoApi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApi.model.User

class AdapterShowListApi(

    var listOfUserApi : MutableList<User>

) : RecyclerView.Adapter<ItemListUserApiHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListUserApiHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fake_user_api, parent,false)
        return ItemListUserApiHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListUserApiHolder, position: Int) {
        listOfUserApi[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfUserApi.size
    }

    // TODO: 06/08/21 Chaman uma lista vazia para preecher com as info da Api
    fun refreshListApi(list : List<User>){
        listOfUserApi = mutableListOf()
        listOfUserApi.addAll(list)
        notifyDataSetChanged()
    }


}

class ItemListUserApiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind (user : User) {
        itemView.findViewById<TextView>(R.id.textViewIdUser).apply {
            text = user.id
        }
        itemView.findViewById<TextView>(R.id.textViewEmailUser).apply {
            text = user.email
        }
        itemView.findViewById<TextView>(R.id.textViewPhoneUser).apply {
            text = user.phone
        }
    }
}