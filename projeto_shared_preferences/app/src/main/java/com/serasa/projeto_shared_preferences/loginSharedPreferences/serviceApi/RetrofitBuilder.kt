package com.serasa.projeto_shared_preferences.loginSharedPreferences.serviceApi

object RetrofitBuilder {

    fun getConnectionFakeApi() : Endpoint {
        return ConnectRetrofit
            .getRetrofitInstance("https://fakestoreapi.com")
            .create(Endpoint::class.java)
    }
}