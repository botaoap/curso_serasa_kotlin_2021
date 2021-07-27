package com.serasa.primeiroprojetoandroid.classes

class Cachorro : Animal("mamifero") {

    override fun movimento() {
        super.movimento()
        println("Cachorro caminha com quatro patas")
    }
}