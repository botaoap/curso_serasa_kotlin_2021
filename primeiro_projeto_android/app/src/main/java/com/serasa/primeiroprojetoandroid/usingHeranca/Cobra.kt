package com.serasa.primeiroprojetoandroid.usingHeranca

class Cobra : Animal("reptil") {
    override fun movimento() {
        super.movimento()
        println("Cobra rasteja")
    }
}