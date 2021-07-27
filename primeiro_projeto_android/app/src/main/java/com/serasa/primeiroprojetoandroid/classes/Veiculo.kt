package com.serasa.primeiroprojetoandroid.classes

class Veiculo(
    var motor: String,
    var combustivel: String,
){

    constructor() : this("","")

    constructor(motor: String) : this(motor, "")

    // TODO: usando if para validar
    fun verificarMotorBoolean(): Boolean {
        if (motor.isNotEmpty() && motor.length >= 2)
            return true
        return false
    }

    // TODO: a mesma validaçao sem if
    fun verificarMotorBooleanValidaFacil(): Boolean {
        return motor.isNotEmpty() && motor.length >= 2
    }



    fun verificarMotor() {
        println(motor)
    }

    fun verificarCombustivel() {
        println(combustivel)
    }

}