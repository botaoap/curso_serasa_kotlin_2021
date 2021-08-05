package com.serasa.login_serasa.exercicioLoginSerasa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.exercicioLoginSerasa.adapter.AdapterLogin

class ListaContaActivity : AppCompatActivity() {

    private lateinit var showListRecyclerView: RecyclerView
    private lateinit var adapter: AdapterLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_conta)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showListOfComponent()

    }

    fun showListOfComponent() {

        adapter = AdapterLogin()

        showListRecyclerView = findViewById(R.id.recyclerViewListOfContas)
        showListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        showListRecyclerView.adapter = adapter

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}