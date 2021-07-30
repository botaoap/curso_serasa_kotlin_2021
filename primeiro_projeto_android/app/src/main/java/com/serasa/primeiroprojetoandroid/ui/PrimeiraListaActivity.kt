package com.serasa.primeiroprojetoandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serasa.primeiroprojetoandroid.R
import com.serasa.primeiroprojetoandroid.usingAdapter.AdapterListaNomes

class PrimeiraListaActivity : AppCompatActivity() {

    lateinit var recycleViewNomes : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_lista)

        chamandoRecycleView()

    }

    fun chamandoRecycleView() {

        val arrayNomesTeste = arrayListOf("Arthur", "Gabriel", "Sergio", "Heloise", "Arthur", "Gabriel", "Sergio", "Heloise")
        recycleViewNomes = findViewById(R.id.recycleViewLista)
        // TODO: Usando o adapter, é a peça fundamental para funcionar
        recycleViewNomes.adapter = AdapterListaNomes(arrayNomesTeste) { nome, id ->
            Snackbar.make(recycleViewNomes, "Id: $id | Nome: $nome ", Snackbar.LENGTH_LONG).show()
        }
        // TODO: Quem sera o motor e o layoutManager do adapter
        recycleViewNomes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // TODO: Layout para deslizar horizontal
        // recycleViewNomes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

}