package com.serasa.manipulando_lista_interface.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.singleton.ListaControle

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        ListaControle.nomes.remove("Joao")
    }

    override fun onResume() {
        println("ON RESUMO")

        Snackbar.make(window.decorView,
            "Lista com: ${ListaControle.nomes.size} elementos",
            Snackbar.LENGTH_LONG).show()

        super.onResume()
    }
}