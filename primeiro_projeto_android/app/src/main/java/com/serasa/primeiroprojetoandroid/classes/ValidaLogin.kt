package com.serasa.primeiroprojetoandroid.classes

class ValidaLogin(
    var nome: String,
    var email: String
) {

    constructor(): this("","")

    constructor(nome: String): this(nome,"")

    fun validaEmail(): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validaNome(): Boolean{
        return nome.isNotBlank()
    }

    fun getInformation(): String {
        return """
            |Nome: $nome 
            |Email $email
            |"""
    }
}