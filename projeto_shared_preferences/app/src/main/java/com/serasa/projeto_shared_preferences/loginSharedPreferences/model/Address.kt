package com.serasa.projeto_shared_preferences.loginSharedPreferences.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("zipcode")
    val zipCode: String
)
