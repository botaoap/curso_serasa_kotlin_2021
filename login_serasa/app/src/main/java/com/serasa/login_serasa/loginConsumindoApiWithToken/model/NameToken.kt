package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import com.google.gson.annotations.SerializedName

data class NameToken(

    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
)
