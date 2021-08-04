package com.serasa.login_serasa.adapter

import com.serasa.login_serasa.model.Login

interface ClickableLogin {

    fun onLogin(login : Login)
    fun onCadastro(cadastro: Login)
}