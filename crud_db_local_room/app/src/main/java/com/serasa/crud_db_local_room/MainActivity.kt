package com.serasa.crud_db_local_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.serasa.crud_db_local_room.databinding.MainActivityBinding
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view.CategoryFragment
import com.serasa.crud_db_local_room.view.MainFragment
import com.serasa.crud_db_local_room.view.ProductFragment
import com.serasa.crud_db_local_room.view.SignInFragment

class MainActivity : AppCompatActivity() {

    private var auth = AuthenticantionRepository()
    private lateinit var binding: MainActivityBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (auth.currentUser() != null) {

            replaceView(CategoryFragment.newInstance())

        } else {
            replaceView(SignInFragment.newInstance())
//            hideBottomBar(false)
        }

        bottomNav = binding.bottomNavigation
        buttonsClick()

    }

    fun buttonsClick() {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> replaceView(CategoryFragment.newInstance())
                R.id.page_2 -> replaceView(ProductFragment.newInstance())
                R.id.page_3 -> replaceView(MainFragment.newInstance())
            }
            return@setOnItemSelectedListener true
        }
    }


    fun hideBottomBar(visible: Boolean) {
        binding.bottomNavigation.visibility = if (visible) VISIBLE else GONE
        println(binding.bottomNavigation.visibility)
    }
}