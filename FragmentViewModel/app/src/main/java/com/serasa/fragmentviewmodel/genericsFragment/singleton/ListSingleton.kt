package com.serasa.fragmentviewmodel.genericsFragment.singleton


import com.serasa.fragmentviewmodel.genericsFragment.model.Carro
import com.serasa.fragmentviewmodel.genericsFragment.model.Nome

object ListSingleton {
    val listOfNome = mutableListOf(
        Nome(1,"Jorge"),
        Nome(2,"Ana"),
        Nome(3,"Roberto"),
        Nome(4,"Gabriel"),
        Nome(5,"Heloise")
    )
    val listofCarro = mutableListOf(
        Carro(1,"AMG A 45 S", 2021),
        Carro(2,"Class S", 2022),
        Carro(3,"Focus", 2020),
        Carro(4,"Celta", 2019),
        Carro(5,"AMG A 45", 2021),
    )
}