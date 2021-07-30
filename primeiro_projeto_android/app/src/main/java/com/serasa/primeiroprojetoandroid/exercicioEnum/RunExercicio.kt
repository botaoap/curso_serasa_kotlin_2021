package com.serasa.primeiroprojetoandroid.exercicioEnum

fun main() {

    chamandoPessoa(TipoPessoaEnum.ADM)
}

fun chamandoPessoa(tipo: TipoPessoaEnum) {
    when (tipo) {
        TipoPessoaEnum.ALUNO -> println("Tipo Pessoa: ${TipoPessoaEnum.ALUNO} | Id: ${TipoPessoaEnum.ALUNO.id}")
        TipoPessoaEnum.PROFESSOR -> println("Tipo Pessoa: ${TipoPessoaEnum.PROFESSOR} | Id: ${TipoPessoaEnum.PROFESSOR.id}")
        TipoPessoaEnum.ADM -> println("Tipo Pessoa: ${TipoPessoaEnum.ADM} | Id: ${TipoPessoaEnum.ADM.id}")
    }
}