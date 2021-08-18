package com.serasa.exercise_firebase_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view.MainFragment
import com.serasa.exercise_firebase_mvvm.view.SignInFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

            replaceView(SignInFragment.newInstance())
        }
    }
}