package com.serasa.login_serasa.exercicioLoginSerasa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.serasa.login_serasa.R
import com.serasa.login_serasa.exercicioLoginSerasa.model.Login
import com.serasa.login_serasa.exercicioLoginSerasa.model.LogoLogin
import com.serasa.login_serasa.exercicioLoginSerasa.singleton.LoginSingleton

class MainActivity : AppCompatActivity() {

    private lateinit var inputCpf: EditText
    private lateinit var inputPws: EditText
    private lateinit var buttonLogin: Button
    private lateinit var logoSerasa : ImageView

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
        logoSerasa = findViewById(R.id.imageViewAvatarLogin)

        findViewById<ImageView>(R.id.imageViewAvatarLogin).apply {
            Glide.with(logoSerasa)
                .load(LogoLogin.LOGO_SERASA.url)
                .placeholder(R.drawable.ic_baseline_error_24)
                .into(this)
        }

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