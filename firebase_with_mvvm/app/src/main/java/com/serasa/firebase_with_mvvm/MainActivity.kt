package com.serasa.firebase_with_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.serasa.firebase_with_mvvm.utils.replaceView
import com.serasa.firebase_with_mvvm.view.ContentFragment
import com.serasa.firebase_with_mvvm.view.SignInFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (FirebaseAuth.getInstance().currentUser != null){
            replaceView(ContentFragment.newInstance())
        }else {
            replaceView(SignInFragment.newInstance())
        }

    }

}