package com.serasa.login_serasa.loginConsumindoApi.model

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.io.SerializablePermission

data class User(

    @SerializedName("id")
    var id : String,

    @SerializedName("email")
    var email : String,

    @SerializedName("username")
    var userName : String,

    @SerializedName("password")
    var password : String,

    @SerializedName("phone")
    var phone : String,

    val name: Name,

    val address: Address
) : Serializable
