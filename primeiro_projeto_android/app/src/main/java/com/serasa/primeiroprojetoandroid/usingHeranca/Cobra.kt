package com.serasa.primeiroprojetoandroid.usingHeranca

import com.serasa.primeiroprojetoandroid.usingInterface.Som

class Cobra : Animal("reptil") {
    override fun movimento() {
        super.movimento()
        println("Cobra rasteja")
    }

    override fun ruido(): String {
        return "Shshshsh ....."
    }

    override fun frente(): String {
        return "Rasteja para frente ......"
    }

    override fun lado(): String {
        return "Rola para o lado ......"
    }

    override fun random(): String {
        return "Rasteja para qualquer lugar ......."
    }


}