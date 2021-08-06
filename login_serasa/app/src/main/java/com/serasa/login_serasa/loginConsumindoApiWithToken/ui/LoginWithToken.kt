package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApi.model.User
import com.serasa.login_serasa.loginConsumindoApi.serviceApi.ConnectionWithRetrofit
import com.serasa.login_serasa.loginConsumindoApi.serviceApi.EndpointUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginWithToken : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_token)
    }

}
