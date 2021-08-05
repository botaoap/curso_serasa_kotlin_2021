package com.serasa.login_serasa.exercicioLoginSerasa.adapter

import com.serasa.login_serasa.exercicioLoginSerasa.model.Login

interface ClickableLogin {

    fun onLogin(login : Login)
    fun onCadastro(cadastro: Login)
}