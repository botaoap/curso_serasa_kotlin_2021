package com.serasa.primeiroprojetoandroid.usingHeranca

import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Cachorro(val nome: String) : Animal("mamifero"){

    override fun movimento() {
        super.movimento()
        println("Cachorro caminha com quatro patas")
    }

    override fun ruido() : String{
        return "Latido......."
    }

    override fun frente(): String {
        return "Caminha com 4 patas para frente ......"
    }

    override fun lado(): String {
        return "Caminha com 4 patas de lado......"
    }

    override fun random(): String {
        return "Caminha com 4 patas para qualquer lugar ....."
    }


}