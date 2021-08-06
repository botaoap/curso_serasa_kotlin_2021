package com.serasa.login_serasa.loginConsumindoApi.model

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id")
    var id : String,

    @SerializedName("email")
    var email : String,

    @SerializedName("username")
    var userName : String,

    @SerializedName("password")
    var password : String

)
