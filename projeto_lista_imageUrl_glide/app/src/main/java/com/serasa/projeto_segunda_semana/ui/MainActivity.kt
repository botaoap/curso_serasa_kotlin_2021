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
            Car("Mercedes", "AMG A 45 S",2019,
                "https://cdn.motor1.com/images/mgl/W3Ze6/s3/mercedes-amg-a-45-4matic-2019.jpg"),
            Car("Mercedes", "AMG Class S",2021,
                "https://allthecars.files.wordpress.com/2017/09/mercedes-benz-s63-amg-coupe-1.jpg"),
            Car("BMW", "M340i",2018,
                "https://s2.glbimg.com/RMGMq_Csr-LAh1nke_Yw6NUTrfc=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/L/a/BQ1uFmQGOxTBiVtgzX6w/2020-06-01-bmw-m340i-3.jpeg"),
            Car("Chevrolet", "Camaro",2017,
                "https://quatrorodas.abril.com.br/wp-content/uploads/2019/05/2020-chevrolet-camaross-001.jpg?quality=70&strip=info"),
            Car("Dodge", "Muscle Car",1999,
                "https://s2.glbimg.com/3E_xKxwL59DvNDe99IegBj4zx9Q=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/e/K/vBsgTWS7eMsqM9NAWqCQ/2020-07-03-dodge-challenger-srt-super-stock-2020-04.jpg"),
        )


        carReclycerView = findViewById(R.id.carsRecyclerView)
        carReclycerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        carReclycerView.adapter = AdapterRecyclerView(listOfCars)


    }
}