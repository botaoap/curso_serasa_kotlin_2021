package com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi

import com.serasa.login_serasa.loginConsumindoApiWithToken.endpoint.ServiceUser
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Auth
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilders {

    fun getAuthenticationServices(): ServiceUser {
        return ConnectionRetrofitWithToken
            .getRetrofitInstance(LinksApi.FAKE_STORE_API.url)
            .create(ServiceUser::class.java)
    }

}