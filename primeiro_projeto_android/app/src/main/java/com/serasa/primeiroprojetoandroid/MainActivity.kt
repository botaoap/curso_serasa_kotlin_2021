package com.serasa.primeiroprojetoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.serasa.primeiroprojetoandroid.classeFormulario.Formulario
import com.serasa.primeiroprojetoandroid.classes.*
import com.serasa.primeiroprojetoandroid.usingHeranca.Cachorro
import com.serasa.primeiroprojetoandroid.usingHeranca.Cobra
import com.serasa.primeiroprojetoandroid.usingHeranca2.PessoaFisica
import com.serasa.primeiroprojetoandroid.usingHeranca2.PessoaJuridica

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_treino)

        // classeVeiculo()
        // classeValidaLogin()
        // classeValidaProfessor()
        // metodosHeranca()
        // herancaPessoa()
        //formularioAntigo()
        chamandoButton()

    }

    /**
     * Funcao de click - Disparada quando usuario clica no componente
     * em que add o evento do onClickListener
     */

    fun chamandoButton() {

        val button = findViewById<Button>(R.id.buttonEnviar)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when(it.id) {
//                is Button -> {
//                   val button = it as Button
//                }
                R.id.buttonEnviar -> {
                    Snackbar.make(
                        it,
                        "Teste interessante",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                else -> println("")
            }
        }
    }

    fun formularioAntigo(){
        // TODO: chamando elemento de forma antiga
        findViewById<Button>(R.id.buttonEnviar).apply {

            setOnClickListener {
                checkFields(it)
            //  Snackbar.make(it, "Click Ok", Snackbar.LENGTH_LONG).show()
            }
        }
    }


    private fun checkFields(view: View) {
        // TODO: funcao para validar os campos do formulario chamando uma classe Formulario
        // TODO: Precisa criar um parametro do tipo View para usar o Snackbar

        val form = Formulario()

        findViewById<EditText>(R.id.editTextNome).apply {
            form.nome = text.toString()
        }

        findViewById<EditText>(R.id.editTextEmail).apply {
            form.email = text.toString()
        }

        findViewById<EditText>(R.id.editTextCelular).apply {
            form.celular = text.toString()
        }
        if (form.checkFields()) {
            // TODO: para chamar classe precisa de `::`
            val intent = Intent(this, ApplicationActivity::class.java)

            // TODO: chama uma nova activity (forma mais basica de navegar por telas)
            startActivity(intent)

            /*
            Snackbar.make(
                view,
                "Nome: ${form.nome}, Email: ${form.email}, Celular: ${form.celular}",
                Snackbar.LENGTH_LONG
            ).show()*/
        } else {
            Snackbar.make(
                view,
                getString(R.string.message_error_form),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    fun herancaPessoa(){
        val pessoaFisica = PessoaFisica()
        pessoaFisica.identificar()
        pessoaFisica.tipoDeRegistro()
        pessoaFisica.emiteNotaFiscal()

        val pessoaJuridica = PessoaJuridica()
        pessoaJuridica.identificar()
        pessoaJuridica.tipoDeRegistro()
        pessoaJuridica.emiteNotaFiscal()
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