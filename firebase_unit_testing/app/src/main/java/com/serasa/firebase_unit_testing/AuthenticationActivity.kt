package com.serasa.firebase_unit_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.firebase_unit_testing.view.SignInFragment

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignInFragment())
                .commitNow()
        }
    }
}