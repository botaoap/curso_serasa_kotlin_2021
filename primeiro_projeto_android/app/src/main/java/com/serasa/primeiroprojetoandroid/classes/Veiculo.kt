package com.serasa.primeiroprojetoandroid.classes

import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Veiculo(
    var motor: String,
    var combustivel: String,
): Som {

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

    override fun ruido(): String {
        return "Ligando motor ...."
    }

}