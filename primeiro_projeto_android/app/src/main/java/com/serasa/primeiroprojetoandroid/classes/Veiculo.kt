package com.serasa.primeiroprojetoandroid.classes

class Veiculo(
    private val motor: String,
    var combustivel: String,
){

    fun verificarMotor() {
        println(motor)
    }

}