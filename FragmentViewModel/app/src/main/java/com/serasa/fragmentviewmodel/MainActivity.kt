package com.serasa.fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.serasa.fragmentviewmodel.fragments.PrimeiroFragment
import com.serasa.fragmentviewmodel.fragments.SegundoFragment

class MainActivity : AppCompatActivity() {

    private var tipoFragment = TypeFragment.PRIMEIRO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.buttonReplace).apply {
            setOnClickListener {
                if (tipoFragment == TypeFragment.PRIMEIRO) {
                    replaceFrag(PrimeiroFragment())
                    tipoFragment = TypeFragment.SEGUNDO
                } else if (tipoFragment == TypeFragment.SEGUNDO) {
                    replaceFrag(SegundoFragment())
                    tipoFragment = TypeFragment.PRIMEIRO
                }
            }
        }
    }

    private fun replaceFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}

enum class TypeFragment {
    PRIMEIRO,
    SEGUNDO
}