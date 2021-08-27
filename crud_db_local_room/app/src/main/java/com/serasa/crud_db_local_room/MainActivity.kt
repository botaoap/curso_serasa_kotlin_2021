package com.serasa.crud_db_local_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view.CategoryFragment
import com.serasa.crud_db_local_room.view.MainFragment
import com.serasa.crud_db_local_room.view.SignInFragment

class MainActivity : AppCompatActivity() {

    private var auth = AuthenticantionRepository()

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