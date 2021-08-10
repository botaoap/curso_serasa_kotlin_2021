package com.serasa.fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.fragmentviewmodel.fragments.PrimeiroFragment
import com.serasa.fragmentviewmodel.fragments.SegundoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, PrimeiroFragment())
                .commitNow()

            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, SegundoFragment())
                .commitNow()
        }
    }
}