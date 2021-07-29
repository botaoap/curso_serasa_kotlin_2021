package com.serasa.primeiroprojetoandroid.usingHeranca

class Cachorro : Animal("mamifero") {

    override fun movimento() {
        super.movimento()
        println("Cachorro caminha com quatro patas")
    }
}