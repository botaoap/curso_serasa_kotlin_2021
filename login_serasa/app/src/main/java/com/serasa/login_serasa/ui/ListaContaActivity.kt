package com.serasa.login_serasa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.login_serasa.R

class ListaContaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_conta)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }



}