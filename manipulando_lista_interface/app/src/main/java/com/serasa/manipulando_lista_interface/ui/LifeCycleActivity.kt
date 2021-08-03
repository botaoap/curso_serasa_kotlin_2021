package com.serasa.manipulando_lista_interface.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.manipulando_lista_interface.R

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        println("ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

    }

    override fun onStart() {
       println("ON START")
       super.onStart()
    }

    override fun onResume() {
        println("ON RESUMO")
        super.onResume()
    }

    override fun onRestart() {
        println("ON RESTART")
        super.onRestart()
    }

    override fun onPause() {
        println("ON PAUSE")
        super.onPause()
    }

    override fun onStop() {
        println("ON STOP")
        super.onStop()
    }

    override fun onDestroy() {
        println("ON DESTROY")
        super.onDestroy()
    }

}