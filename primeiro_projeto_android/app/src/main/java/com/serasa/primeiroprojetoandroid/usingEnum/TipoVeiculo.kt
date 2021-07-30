package com.serasa.primeiroprojetoandroid.usingEnum

enum class TipoVeiculo(val id: Int, val key: String) {
    CARRO(1, "key_carro"),
    MOTO(2, "key_moto"),
    CAMINHAO(3, "key_caminhao")
}