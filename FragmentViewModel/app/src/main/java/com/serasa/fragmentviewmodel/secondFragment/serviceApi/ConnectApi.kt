package com.serasa.fragmentviewmodel.secondFragment.serviceApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectApi {

    companion object {
        fun getConnectionApi(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}