package com.serasa.architecture_mvvm.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("name")
    val name: String
)