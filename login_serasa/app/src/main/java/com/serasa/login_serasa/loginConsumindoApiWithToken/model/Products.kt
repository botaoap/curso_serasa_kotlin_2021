package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName

data class Products(

    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String
)
