package com.serasa.primeiroprojetoandroid.classes

class PessoaJuridica: Pessoa("Pessoa Juridica",
    "CNPJ", true) {
    override fun identificar() {
        super.identificar()
        println("Pessoa Juridica")
    }

    override fun tipoDeRegistro() {
        super.tipoDeRegistro()
        println("CNPJ")
    }

    override fun emiteNotaFiscal() {
        super.emiteNotaFiscal()
        println("True")
    }
}