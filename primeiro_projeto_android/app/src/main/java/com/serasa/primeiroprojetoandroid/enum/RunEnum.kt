package com.serasa.primeiroprojetoandroid.enum

fun main() {

    printTipoVeiculo(TipoVeiculo.CAMINHAO)

}

fun printTipoVeiculo(tipo: TipoVeiculo) {
    when (tipo) {
        TipoVeiculo.CARRO -> println("Selecionado: ${TipoVeiculo.CARRO} | Key: ${TipoVeiculo.CARRO.key}")
        TipoVeiculo.MOTO -> println("Selecionado: ${TipoVeiculo.MOTO} | Key: ${TipoVeiculo.MOTO.key}")
        TipoVeiculo.CAMINHAO -> println("Selecionado: ${TipoVeiculo.CAMINHAO} | Key: ${TipoVeiculo.CAMINHAO.key}")
    }
}