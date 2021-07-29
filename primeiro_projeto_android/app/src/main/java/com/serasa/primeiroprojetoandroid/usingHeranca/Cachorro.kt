package com.serasa.primeiroprojetoandroid.usingHeranca

import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Cachorro : Animal("mamifero"), Som {

    override fun movimento() {
        super.movimento()
        println("Cachorro caminha com quatro patas")
    }

    override fun ruido() : String{
        return "Latido......."
    }
}