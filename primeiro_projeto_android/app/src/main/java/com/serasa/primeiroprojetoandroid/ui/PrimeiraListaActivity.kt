package com.serasa.primeiroprojetoandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.serasa.primeiroprojetoandroid.R

class PrimeiraListaActivity : AppCompatActivity() {

    lateinit var recycledViewNomes : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_lista)

        chamandoRecycleView()

    }

    fun chamandoRecycleView() {
        recycledViewNomes = findViewById(R.id.recycleViewLista)

        // TODO: Usando o adapter, é a peça fundamental para funcionar

        // recycledViewNomes


    }

}