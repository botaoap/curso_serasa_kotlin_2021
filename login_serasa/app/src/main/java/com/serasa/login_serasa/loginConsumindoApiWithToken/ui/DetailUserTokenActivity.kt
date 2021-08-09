package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serasa.login_serasa.R

class DetailUserTokenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user_token)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}