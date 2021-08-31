package com.serasa.dependency_injection_users_github.model

import com.google.gson.annotations.SerializedName
import retrofit2.SkipCallbackExecutor

data class User(
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("avatar_url")
    val image: String
)