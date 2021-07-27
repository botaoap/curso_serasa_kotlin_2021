package com.serasa.primeiroprojetoandroid.classes
// TODO: Classes di tipo OPEN sera herdada por alguem
open class Animal(
    val categoria: String
) {
    open fun movimento(){
        println("animal se movimentando")
    }
}