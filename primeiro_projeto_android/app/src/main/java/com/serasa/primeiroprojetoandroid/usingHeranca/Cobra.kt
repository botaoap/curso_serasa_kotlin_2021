package com.serasa.primeiroprojetoandroid.usingHeranca

import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Cobra : Animal("reptil"), Som {
    override fun movimento() {
        super.movimento()
        println("Cobra rasteja")
    }

    override fun ruido(): String {
        return "Shshshsh ....."
    }
}