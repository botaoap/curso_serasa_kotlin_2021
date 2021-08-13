package com.serasa.projeto_shared_preferences.loginSharedPreferences.serviceApi

import retrofit.GsonConverterFactory
import retrofit.Retrofit

class ConnectRetrofit {
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