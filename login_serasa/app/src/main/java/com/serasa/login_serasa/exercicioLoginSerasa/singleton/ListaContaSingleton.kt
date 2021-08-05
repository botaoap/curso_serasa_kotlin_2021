package com.serasa.login_serasa.exercicioLoginSerasa.singleton

import com.serasa.login_serasa.exercicioLoginSerasa.model.ListaConta
import com.serasa.login_serasa.exercicioLoginSerasa.model.LogoListaConta

object ListaContaSingleton {

    val conta = mutableListOf<ListaConta>(
        ListaConta("Credito",1000.00,"", LogoListaConta.CREDITO),
        ListaConta("Debito",100.00,"", LogoListaConta.DEBITO),
        ListaConta("Pago",150.00,"", LogoListaConta.PAGO),
    )
}