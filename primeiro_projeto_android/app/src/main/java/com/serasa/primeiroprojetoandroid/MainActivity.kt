package com.serasa.primeiroprojetoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.primeiroprojetoandroid.classes.Veiculo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val veiculo = Veiculo("v6")
    }
}