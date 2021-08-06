package com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionRetrofitWithToken {

    companion object {

        /**
         * Nesta funcao passamos o caminho da API e o retrofit faz a connection
         */
        fun getRetrofitInstance(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}