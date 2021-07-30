package com.serasa.primeiroprojetoandroid.usingArray

import com.serasa.primeiroprojetoandroid.usingHeranca.Animal
import com.serasa.primeiroprojetoandroid.usingHeranca.Cachorro

fun main() {
    val arrayDeNumeros = arrayOf(10, 20, 30, 3, 5)

    val arrayDeString = emptyArray<String>()

    val a = ArrayList<String>()
    a.add("a")
    a.add("b")
    a.add("c")
    a.add("d")

    val animal = ArrayList<Animal>()
    animal.add(Cachorro())

    println(animal[0])



}