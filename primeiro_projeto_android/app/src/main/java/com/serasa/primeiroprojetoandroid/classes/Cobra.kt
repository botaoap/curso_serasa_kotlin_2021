package com.serasa.primeiroprojetoandroid.classes

class Cobra : Animal("reptil") {
    override fun movimento() {
        super.movimento()
        println("Cobra rasteja")
    }
}