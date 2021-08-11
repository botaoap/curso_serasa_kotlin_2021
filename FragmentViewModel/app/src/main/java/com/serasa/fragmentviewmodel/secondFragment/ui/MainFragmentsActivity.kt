package com.serasa.fragmentviewmodel.secondFragment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.secondFragment.fragments.FirstScreenFragment
import com.serasa.fragmentviewmodel.secondFragment.fragments.GetAllScreenFragment
import com.serasa.fragmentviewmodel.secondFragment.fragments.ListOfProductsFragment
import com.serasa.fragmentviewmodel.secondFragment.fragments.SecondScreenFragment

class MainFragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragments)

        setMenuBottomBar()
    }

    fun setMenuBottomBar() {

        replaceFrag(FirstScreenFragment())

        findViewById<BottomNavigationView>(R.id.bottom_navigation).apply {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.page_1 -> {
                        // Respond to navigation item 1 click
                        replaceFrag(FirstScreenFragment())
                        true
                    }
                    R.id.page_2 -> {
                        // Respond to navigation item 2 click
                        replaceFrag(SecondScreenFragment())
                        true
                    }
                    R.id.page_3 -> {
                        replaceFrag(ListOfProductsFragment())
                        true
                    }
                    R.id.page_4 -> {
                        replaceFrag(GetAllScreenFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMain, fragment)
            .commitNow()
    }

}