package com.serasa.login_serasa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import com.serasa.login_serasa.R
import com.serasa.login_serasa.adapter.ClickableLogin
import com.serasa.login_serasa.model.Login
import com.serasa.login_serasa.singleton.LoginSingleton

class MainActivity : AppCompatActivity() {

    private lateinit var inputCpf: EditText
    private lateinit var inputPws: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chamandoElementosNaTela()


    }

    fun chamandoElementosNaTela() {
        // TODO: passando os elementos do XML para variaveis
        inputCpf = findViewById(R.id.editTextCpf)
        inputPws = findViewById(R.id.editTextPws)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            if (validaCamposParaLogin()){
                fazerLogin()
            }else {
                inputCpf.error = "CPF invalido"
                inputPws.error = "Senha invalida"
            }
        }

    }

    private fun validaCamposParaLogin() : Boolean {
        val cpf = inputCpf.text.toString()
        val pws = inputPws.text.toString()

        if (cpf.isNotEmpty() && pws.isNotEmpty()){
            LoginSingleton.cpfLogin = Login(cpf,pws)
            return LoginSingleton.cpfLogin!!.isValidCpf() && LoginSingleton.cpfLogin!!.isVlaidPws()
        }
        return false
    }

    private fun fazerLogin() {
        // TODO: nesa funcao chamamos a outra tela
        Intent(this, ListaContaActivity::class.java).apply{
            startActivity(this)
        }
    }
}