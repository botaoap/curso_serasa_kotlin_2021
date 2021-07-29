package com.serasa.primeiroprojetoandroid.exercicioInterface

class Programador : Profissao("Mobile Developer"){

    override fun trabalho() {
        super.trabalho()
        println("de Mobile Developer")
    }

    override fun cafe(): String {
        return "Developer precisa de Cafe ...."
    }


}