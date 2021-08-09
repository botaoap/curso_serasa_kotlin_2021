package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("token")
    val token: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("msg")
    val msg: String?
) {

    fun isError() : Boolean {
        return token == null || token.isEmpty()
    }

}