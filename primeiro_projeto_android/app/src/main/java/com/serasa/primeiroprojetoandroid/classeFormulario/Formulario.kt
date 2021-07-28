package com.serasa.primeiroprojetoandroid.classeFormulario

class Formulario(
    var nome: String?,
    var email: String?,
    var celular: String?
) {
    constructor(): this(null,null,null)

    // TODO: Funcao de tratamento do formulario
    fun checkFields(): Boolean {
        return checkNome() && checkEmail() && checkCelular()
    }

    fun checkNome(): Boolean {
        return !nome.isNullOrEmpty()
    }

    fun checkEmail(): Boolean {
        return !email.isNullOrEmpty()
    }

    fun checkCelular(): Boolean {
        return !celular.isNullOrEmpty()
    }

}