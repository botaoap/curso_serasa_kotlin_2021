package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import com.google.gson.annotations.SerializedName

data class AddressToken(

    @SerializedName("city")
    val city: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("zipcode")
    val zipcode: String
)
