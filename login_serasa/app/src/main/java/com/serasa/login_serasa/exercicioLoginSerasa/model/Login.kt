package com.serasa.login_serasa.exercicioLoginSerasa.model

import java.io.Serializable

data class Login(
    val cpf: String,
    val pws: String,
): Serializable {
    fun isValidCpf() : Boolean{
        return cpf.length == 11
    }

    fun isVlaidPws() : Boolean{
        return pws.length >= 6
    }
}