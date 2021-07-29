package com.serasa.primeiroprojetoandroid.usingHeranca
// TODO: Classes di tipo OPEN sera herdada por alguem
open class Animal(
    val categoria: String
) {
    open fun movimento(){
        println("Animal se movimentando")
    }
}