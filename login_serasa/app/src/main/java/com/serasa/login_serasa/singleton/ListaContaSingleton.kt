package com.serasa.login_serasa.singleton

import com.serasa.login_serasa.model.ListaConta
import com.serasa.login_serasa.model.LogoListaConta

object ListaContaSingleton {

    val conta = mutableListOf<ListaConta>(
        ListaConta("Credito",1000.00,"", LogoListaConta.CREDITO),
        ListaConta("Debito",100.0,"", LogoListaConta.DEBITO),
        ListaConta("Pago",150.0,"", LogoListaConta.PAGO),
    )
}