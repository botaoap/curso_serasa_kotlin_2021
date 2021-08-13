package com.serasa.projeto_shared_preferences.loginSharedPreferences.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.serasa.projeto_shared_preferences.R
import com.serasa.projeto_shared_preferences.loginSharedPreferences.fragment.DetailUserFragment
import com.serasa.projeto_shared_preferences.loginSharedPreferences.fragment.LoginFragment

class MainLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        replaceFrag(LoginFragment())

    }

    fun replaceFrag(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLoginActivity,fragment)
            .commitNow()
    }
}