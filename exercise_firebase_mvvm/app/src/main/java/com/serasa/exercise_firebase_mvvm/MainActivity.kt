package com.serasa.exercise_firebase_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.ktx.Firebase
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view.MainFragment
import com.serasa.exercise_firebase_mvvm.view.SignInFragment

class MainActivity : AppCompatActivity() {

    private var auth = AuthenticationRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (auth.currentUser() != null) {
            replaceView(MainFragment.newInstance())
        } else {
            replaceView(SignInFragment.newInstance())
        }
    }
}