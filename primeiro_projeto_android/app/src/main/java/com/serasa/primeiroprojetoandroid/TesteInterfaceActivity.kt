package com.serasa.primeiroprojetoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class TesteInterfaceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste_interface)

        chamandoButton()

    }

    fun chamandoButton() {
        // TODO: Chamando o botao normal
//        val buttonTeste1 = findViewById<Button>(R.id.buttonTeste1)
//        buttonTeste1.setOnClickListener(this)
//
//        val buttonTeste2 = findViewById<Button>(R.id.buttonTeste2)
//        buttonTeste2.setOnClickListener(this)
        // TODO: Usando dois botoes com .apply
        findViewById<Button>(R.id.buttonTeste1).apply {
            // TODO: fica em um loop para escutar o button da View onde esta
            setOnClickListener(this@TesteInterfaceActivity)
        }
        findViewById<Button>(R.id.buttonTeste2).apply {
            setOnClickListener(this@TesteInterfaceActivity)
        }

        findViewById<ConstraintLayout>(R.id.activityTelaTeste).apply {
            setOnClickListener(this@TesteInterfaceActivity)
        }
    }

    override fun onClick(view: View?) {
        view?.let {
         when(it.id) {
             R.id.buttonTeste1 -> {
                 Snackbar.make(it, getString(R.string.message_teste1),
                     Snackbar.LENGTH_LONG).show()
             }
             R.id.buttonTeste2 -> {
                 Snackbar.make(it, getString(R.string.message_teste2),
                     Snackbar.LENGTH_LONG).show()
             }
             R.id.activityTelaTeste -> {
                 Snackbar.make(it,getString(R.string.message_testeTela),
                     Snackbar.LENGTH_LONG).show()
             }
         }
        }
    }











}