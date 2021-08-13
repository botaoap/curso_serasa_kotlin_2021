package com.serasa.projeto_shared_preferences.loginSharedPreferences.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address")
    val address: Address
)
