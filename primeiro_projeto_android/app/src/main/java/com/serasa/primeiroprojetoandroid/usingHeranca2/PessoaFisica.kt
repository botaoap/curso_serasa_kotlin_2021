package com.serasa.primeiroprojetoandroid.usingHeranca2

class PessoaFisica: Pessoa("Pessoa Fisica",
    "CPF", false) {
    override fun identificar() {
        super.identificar()
        println("Pessoa Fisica")
    }

    override fun tipoDeRegistro() {
        super.tipoDeRegistro()
        println("CPF")
    }

    override fun emiteNotaFiscal() {
        super.emiteNotaFiscal()
        println("False")
    }
}