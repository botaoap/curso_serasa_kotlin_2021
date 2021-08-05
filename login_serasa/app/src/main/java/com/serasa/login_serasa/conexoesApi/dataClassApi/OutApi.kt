package com.serasa.login_serasa.conexoesApi.dataClassApi

import com.google.gson.annotations.SerializedName

data class OutApi(

    @SerializedName("nome")
    var name : String,

    @SerializedName("codigo")
    var code : String

)
