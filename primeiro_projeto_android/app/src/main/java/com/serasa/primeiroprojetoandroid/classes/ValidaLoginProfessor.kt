package com.serasa.primeiroprojetoandroid.classes

// TODO: Variavel com '?' significa que ele podeser Nulo(Null)
class ValidaLoginProfessor (var name: String?, var email: String?, veiculo: Veiculo?) {

    constructor() : this(null,null, null)

    fun checkName(): Boolean {
        return !name.isNullOrEmpty()
    }

    fun checkEmail(): Boolean {
        return (!email.isNullOrEmpty() && email!!.contains("@"))
    }

    fun getCompleteInfo(): String {
        return "Email? $email +++++++ Name: $name"
    }

}