package com.serasa.primeiroprojetoandroid.classes
// TODO: Classe mae de pessoa para pessoa fisica e juridica
open class Pessoa(
    val identicarTipoPessoa: String,
    val tipoRegistro: String,
    val emitirNotaFiscal: Boolean
) {

    open fun identicar(){
        print("Tipo da pessoa: ")
    }
    open fun tipoDeRegistro(){
        print("Registro principal: ")
    }

    open fun emiteNotaFiscal(){
        print("Pode emitir nota fiscal: ")
    }

}