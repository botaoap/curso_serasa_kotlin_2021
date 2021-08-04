package com.serasa.manipulando_lista_interface.exercicioSingleton.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.exercicioSingleton.adapter.AdapterSingleton
import com.serasa.manipulando_lista_interface.exercicioSingleton.adapter.ClickableSingleton
import com.serasa.manipulando_lista_interface.exercicioSingleton.model.ProdutoSingleton
import com.serasa.manipulando_lista_interface.exercicioSingleton.singleton.ListaSingleton

class ExSingleton : AppCompatActivity(), ClickableSingleton {

    private lateinit var singletonRecyclerView : RecyclerView
    private lateinit var adapter: AdapterSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_singleton)

        chamandoSingleton()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun chamandoSingleton(){

        adapter = AdapterSingleton(this)

        singletonRecyclerView = findViewById(R.id.RecycleViewItemListaSingleton)
        singletonRecyclerView.layoutManager =  LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        singletonRecyclerView.adapter = adapter


    }

    override fun onDelete(produtoSingleton: ProdutoSingleton) {
        if (singletonRecyclerView.adapter is AdapterSingleton) {
            (singletonRecyclerView.adapter as AdapterSingleton).remove(produtoSingleton)
            atualizarListaSingleton()
        }
    }

    override fun onResume() {
        println("ON RESUME")

        atualizarListaSingleton()

        adapter.refresh()

        super.onResume()
    }

    fun atualizarListaSingleton(){
        findViewById<TextView>(R.id.TextViewQtdItemLista).apply {
            text = "Qtd itens na lista: ${ListaSingleton.listaProdutos.size}"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}