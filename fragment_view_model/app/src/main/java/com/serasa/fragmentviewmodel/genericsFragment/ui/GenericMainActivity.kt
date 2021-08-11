package com.serasa.fragmentviewmodel.genericsFragment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.genericsFragment.fragment.DialogFragmentApp
import com.serasa.fragmentviewmodel.genericsFragment.fragment.GenericListFragment
import com.serasa.fragmentviewmodel.genericsFragment.fragment.TypeOfList

class GenericMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic_main)



        findViewById<Button>(R.id.buttonNome).apply {
            setOnClickListener {
                replaceFrag(GenericListFragment.newInstance(TypeOfList.NOME))
            }
        }
        findViewById<Button>(R.id.buttonCarro).apply {
            setOnClickListener {
                replaceFrag(GenericListFragment.newInstance(TypeOfList.CARRO))
            }
        }
        findViewById<Button>(R.id.buttonDialog).apply {
            setOnClickListener{
                DialogFragmentApp().show(supportFragmentManager,"")
            }
        }
    }

    fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerListGeneric, fragment)
            .commitNow()
    }

}