package com.serasa.primeiroprojetoandroid.classes

class PessoaFisica(): Pessoa("Pessoa Fisica",
    "CPF", false) {
    override fun identicar() {
        super.identicar()
        print("Pessoa Fisica")
    }

    override fun tipoDeRegistro() {
        super.tipoDeRegistro()
        print("CPF")
    }

    override fun emiteNotaFiscal() {
        super.emiteNotaFiscal()
        print("False")
    }
}