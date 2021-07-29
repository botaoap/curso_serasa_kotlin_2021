package com.serasa.primeiroprojetoandroid.classes

import com.serasa.primeiroprojetoandroid.usingInterface.Movimentacao
import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Veiculo(
    var motor: String,
    var combustivel: String,
): Som, Movimentacao {

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

    override fun frente(): String {
        return "Engata a marcha e vai para frente ....."
    }

    override fun lado(): String {
        return "Vira o volante e vai para o lado ....."
    }

    override fun random(): String {
        return "Vai para qualquer lugar ......"
    }

}