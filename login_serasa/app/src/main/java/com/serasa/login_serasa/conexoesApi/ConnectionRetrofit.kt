package com.serasa.login_serasa.conexoesApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionRetrofit {

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