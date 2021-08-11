package com.serasa.fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.serasa.fragmentviewmodel.exempleFragments.fragments.GetAllFragment
import com.serasa.fragmentviewmodel.exempleFragments.fragments.ListFragment
import com.serasa.fragmentviewmodel.exempleFragments.fragments.PrimeiroFragment
import com.serasa.fragmentviewmodel.exempleFragments.fragments.SegundoFragment

class MainActivity : AppCompatActivity() {

    private var tipoFragment = TypeFragment.PRIMEIRO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        findViewById<Button>(R.id.buttonFrag1).apply {
            setOnClickListener {
                replaceFrag(PrimeiroFragment())
            }
        }
        findViewById<Button>(R.id.buttonFrag2).apply {
            setOnClickListener {
                replaceFrag(SegundoFragment())
            }
        }
        findViewById<Button>(R.id.buttonFrag3).apply {
            setOnClickListener {

                replaceFrag(ListFragment())
            }
        }
        findViewById<Button>(R.id.buttonAllFrag).apply {
            setOnClickListener {
                replaceFrag(GetAllFragment())
            }
        }
    }


    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}

enum class TypeFragment {
    PRIMEIRO,
    SEGUNDO,
    TERCEIRO
}