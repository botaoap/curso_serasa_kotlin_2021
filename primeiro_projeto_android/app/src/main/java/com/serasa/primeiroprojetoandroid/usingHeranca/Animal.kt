package com.serasa.primeiroprojetoandroid.usingHeranca

import com.serasa.primeiroprojetoandroid.usingInterface.Movimentacao
import com.serasa.primeiroprojetoandroid.usingInterface.Som

// TODO: Classes dO tipo OPEN sera herdada por alguem
// TODO: Transformar de open para abstract para inserir as interfaces
abstract class Animal(
    val categoria: String
) : Som, Movimentacao {
    open fun movimento(){
        println("Animal se movimentando")
    }


}