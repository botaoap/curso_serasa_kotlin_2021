package com.serasa.architecture_mvvm.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("imageUrl")
    val image: String,
    @SerializedName("newsSite")
    val newsSite: String,
    @SerializedName("summary")
    val summary: String
)