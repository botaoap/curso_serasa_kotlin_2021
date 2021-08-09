package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import com.google.gson.annotations.SerializedName

data class UserToken(

    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: NameToken,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address")
    val address: AddressToken
)
