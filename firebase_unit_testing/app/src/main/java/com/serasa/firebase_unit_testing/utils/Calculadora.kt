package com.serasa.firebase_unit_testing.utils

class Calculadora {

    fun calc(conta: Conta) : Int {
        return if (conta.operacao.op == ETipoOperacao.SOMAR) {
            conta.numero1 + conta.numero2
        } else  {
            conta.numero1 - conta.numero2
        }
    }
}