package com.serasa.projeto_segunda_semana.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.projeto_segunda_semana.R

class MainActivity : AppCompatActivity() {

    private lateinit var carReclycerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        criandolistaRecyclerView()

    }

    fun criandolistaRecyclerView() {

        carReclycerView = findViewById(R.id.carsRecyclerView)
        carReclycerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)



    }
}