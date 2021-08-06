package com.serasa.login_serasa.loginConsumindoApi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApi.adapter.AdapterShowListApi
import com.serasa.login_serasa.loginConsumindoApi.model.User
import com.serasa.login_serasa.loginConsumindoApi.serviceApi.ConnectionWithRetrofit
import com.serasa.login_serasa.loginConsumindoApi.serviceApi.EndpointUser
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginConsumindoApi : AppCompatActivity() {

    // TODO: 06/08/21 Criando lateinit var global para trazer informacoes da tela
    private lateinit var inputUser : EditText
    private lateinit var inputPws : EditText
    private lateinit var buttonLogin : Button
    private lateinit var adapter : AdapterShowListApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_consumindo_api)

        getElementsFromScreen()
        getDataFromApi()
    }


    fun getElementsFromScreen() {
        // TODO: 06/08/21 Pegando os elementos da tela e colocando em variaveis
        inputUser = findViewById<EditText>(R.id.editTextUsername)
        inputPws = findViewById<EditText>(R.id.editTextPassword)
        buttonLogin = findViewById<Button>(R.id.buttonLoginUser)

        // TODO: 06/08/21 Fazendo uma acao para o Button apos preencher os campos
        buttonLogin.setOnClickListener {

        }
    }


    // TODO: 06/08/21 Extraindo informacoes da Api
    fun getDataFromApi() {
        // TODO: 06/08/21 Usando retrofit para passar o link da api
        val retrofitLinkConnection = ConnectionWithRetrofit
            .getRetrofitInstance("https://fakestoreapi.com")

        val endpoit = retrofitLinkConnection.create(EndpointUser::class.java)
        val callback = endpoit.getUsers()

        // TODO: 06/08/21 Verificando se a connection teve sucesso ou nao
        callback.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                println("Sucesso na connection")
                response.body()?.apply {

                    buttonLogin.setOnClickListener {
                        // TODO: 06/08/21 Filtra a lista da Api e retorna o user
                        val filteredListUser = filter { inputUser.text.toString() == it.userName }
                        val filteredListPws = filter { inputPws.text.toString() == it.password}

                        if (filteredListUser.isNotEmpty() && filteredListPws.isNotEmpty()){
                            sucessLogin()
                        }else {
                            inputUser.error = "User Invalid"
                            inputPws.error = "Password Invalid"
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("Falha na connection")
            }
        })
    }


    // TODO: 06/08/21 Fazendo as validacoes dos campos necessarios de acordo com a Api
    private fun validationLogin() : Boolean {

        return false
    }

    // TODO: 06/08/21 Fun que vai para a proxima tela depois da tela de login
    private fun sucessLogin() {
        Intent(this, ExibindoListaApi::class.java).apply {
            startActivity(this)
        }
    }





}