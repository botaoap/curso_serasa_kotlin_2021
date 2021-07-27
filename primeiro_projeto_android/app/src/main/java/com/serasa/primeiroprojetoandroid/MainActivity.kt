package com.serasa.primeiroprojetoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.primeiroprojetoandroid.classes.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // classeVeiculo()
        // classeValidaLogin()
        // classeValidaProfessor()
        // metodosHeranca()

    }

    fun herancaPessia(){
        val pessoaFisica: PessoaFisica()

    }

    fun metodosHeranca() {

        val cachorro = Cachorro()
        cachorro.movimento()

        val cobra = Cobra()
        cobra.movimento()

    }

    fun classeValidaProfessor() {
        val form = ValidaLoginProfessor(null,null,null)
        form.name = "Gabriel"
        form.email = "gabriel@gmail.com"

        if (form.name != null) {
            println(form.name!!.length)
        }

        form.email?.apply {
            println(this)
        }


    }

    fun classeValidaLogin(){
        var validacaoFalse = ValidaLogin().apply {
            validaNome().let {
                println(it)
            }
            validaEmail().let {
                println(it)
            }
            getInformation().let {
                println(it)
            }
        }

        var validacaoTrue = ValidaLogin(nome = "Jorge", email = "jorge@gmail.com").apply {
            validaNome().let {
                println(it)
            }
            validaEmail().let {
                println(it)
            }
            getInformation().let {
                println(it)
            }
        }

        var validacaoEmailFalse = ValidaLogin(nome = "Jorge").apply {
            validaNome().let {
                println(it)
            }
            validaEmail().let {
                println(it)
            }
            getInformation().let {
                println(it)
            }
        }

    }

    fun classeVeiculo(){
        // TODO: val veiculo = Veiculo("v6", "gasolina")
        // TODO: chamar a variavel antes, usar este metodo
        /*
        val veiculo = Veiculo(combustivel = "gasolina", motor = "v6")
        val variavelDoVeiculo = Veiculo(combustivel = "gasolina", motor = "v6")
        variavelDoVeiculo.verificarMotor()
        variavelDoVeiculo.verificarCombustivel()
        */
        // TODO: USANDO METODOS DO KOTLIN(apply, let)
        // TODO: Fazendo o mesmo code de cima em Kotlin
        /*
        Veiculo(combustivel = "diesel", motor="v6").apply {
            verificarCombustivel()
            verificarMotor()
        }
        */

        // TODO: atribuindo uma variavel
        /*
        val primeiroVeiculo = Veiculo().apply {
            // let passa uma variavel
            verificarMotorBooleanValidaFacil().let {
                println(it)
            }
        }
        */

        // TODO: problema nos construtores por causa do tipo da variavel do motor "val"
        /*
        val segundoVeiculo = Veiculo(motor="v8").apply {
            verificarMotorBooleanValidaFacil().let {
                println(it)
            }
        }
        */

        // TODO: METODO TRADICIONAL
    }
}