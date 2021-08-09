package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApiWithToken.extension.snackBar
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Auth
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Credentials
import com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi.RetrofitBuilders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginWithToken : AppCompatActivity(), Callback<Auth> {

    private lateinit var inputUsername: EditText
    private lateinit var inputPassword: EditText
    private lateinit var buttonToken: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_token)

        loadComponents()
        actionToButtonLoginToken()

    }

    fun actionToButtonLoginToken(){
        buttonToken.setOnClickListener{
            fazerLogin()

        }
    }

    private fun fazerLogin() {
        val username = inputUsername.text.toString()
        val password = inputPassword.text.toString()

        val credentirals = Credentials(username, password)

        if (credentirals.checkUserName() && credentirals.checkPassword()) {
                connectionRetrofitToApi(credentirals)
        }else {
            snackBar(inputUsername, R.string.usuario_invalido)
        }
    }

    fun loadComponents() {
        inputUsername = findViewById<EditText>(R.id.editTextUsernameWithToken)
        inputPassword = findViewById<EditText>(R.id.editTextPasswordWithToken)
        buttonToken = findViewById<Button>(R.id.buttonLoginUserWithToken)
    }

    fun connectionRetrofitToApi(credentirals: Credentials) {
        RetrofitBuilders
            .getAuthenticationServices()
            .login(credentirals)
            .clone()
            .enqueue(this)

    //        val getConnection =

//        ConnectionRetrofitWithToken
//            .getRetrofitInstance(LinksApi.FAKE_STORE_API.url)
//            .create(ServiceUser::class.java)
//            .getAll()
//            .clone().enqueue(this)
//        val endpoint = getConnection.create(ServiceUser::class.java)
//        val callback = endpoint.getAll()
//
//        callback.clone().enqueue(this)

    }

    override fun onResponse(call: Call<Auth>, response: Response<Auth>) {
        println("Success Connection")
        response.body()?.let {
            if (response.body()!!.isError()) {
                snackBar(inputUsername, R.string.usuario_invalido)
            } else {
                Intent(this, DetailUserTokenActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

//        val user = response.body()?.let { listOfUser ->
//            listOfUser.filter {
//                inputUsername.text.toString() == it.username
//                inputPassword.text.toString() == it.password
//            }
//        }
//        buttonToken.setOnClickListener {
//            if (user != null) {
//                Intent(this, DetailUserTokenActivity::class.java).apply {
//                    startActivity(this)
//                }
//            } else {
//                println("User don't exist")
//            }
//        }

    }

    override fun onFailure(call: Call<Auth>, t: Throwable) {
        println("Failure Connection")
        snackBar(inputUsername, R.string.usuario_invalido)
    }

}
