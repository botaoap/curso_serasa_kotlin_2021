package com.serasa.projeto_segunda_semana.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.projeto_segunda_semana.R
import com.serasa.projeto_segunda_semana.model.Car
import com.serasa.projeto_segunda_semana.usingAdapterForList.AdapterRecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var carReclycerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        criandolistaRecyclerView()

    }

    fun criandolistaRecyclerView() {

        // TODO: criando array de cars
        val listOfCars = listOf<Car>(
            Car("Mercedes", "AMG A 45 S",2019),
            Car("Mercedes", "AMG Class S",2021),
            Car("BMW", "345i",2018),
            Car("Chevrolet", "Camaro",2017),
            Car("Dodge", "Muscle Car",1999),
        )


        carReclycerView = findViewById(R.id.carsRecyclerView)
        carReclycerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        carReclycerView.adapter = AdapterRecyclerView(listOfCars)


    }
}