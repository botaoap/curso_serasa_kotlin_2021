package com.serasa.primeiroprojetoandroid.usingArray

import com.serasa.primeiroprojetoandroid.usingHeranca.Animal
import com.serasa.primeiroprojetoandroid.usingHeranca.Cachorro
import com.serasa.primeiroprojetoandroid.usingHeranca.Cobra

fun main() {
    val arrayDeNumeros = arrayOf(10, 20, 30, 3, 5)

    val arrayDeString = emptyArray<String>()

    val a = ArrayList<String>()
    a.add("a")
    a.add("b")
    a.add("c")
    a.add("d")

    val animal = ArrayList<Animal>()
    animal.add(Cachorro("bud"))

    //println(animal[0])


    val arrayDeAnimais = arrayListOf<Animal?>()
    arrayDeAnimais.add(Cachorro("bud")) // position 0
    arrayDeAnimais.add(Cobra("snake")) // position 1
    arrayDeAnimais.add(Cobra("chocalho")) // position 2
    arrayDeAnimais.add(null) // position 3

    arrayDeAnimais.size // 4 positions

    // TODO: percorrer lista
    arrayDeAnimais.forEach { animal ->
        // TODO: Chamando -> primeiro metodo
        // println(animal?.categoria)

        // TODO: Chamando -> segundo metodo
//        animal?.apply {
//            // println(this.categoria)
//            // TODO: Usando cast
//            var ruido = ""
              // TODO: Acessando o Ruido da Classe mae Animal
//            if (this is Cobra) {
//                ruido = (this as Cobra).ruido()
//            }else if (this is Cachorro) {
//                ruido = (this as Cachorro).ruido()
//            }
//            println(ruido)
//        }

        // TODO: Acessando Dentro de Cobra e Cachorro
        animal?.apply {
            if (this is Cobra) {
                println("Nome da Cobra: $nome")
            } else if (this is Cachorro) {
                println("Nome do Cachorro: $nome")
            }
        }

    }

    val arrayDeNumero = arrayOf(5, 2, 10, 20, 17, 13, 25)
    arrayDeNumero.forEach {
        println(it)
    }

    println("Numeros Filtrados")

    arrayDeNumero.filter { it > 10 }.sorted().forEach {
        println(it)
    }

}