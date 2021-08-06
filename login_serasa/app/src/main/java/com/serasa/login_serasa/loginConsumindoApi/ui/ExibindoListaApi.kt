package com.serasa.login_serasa.loginConsumindoApi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApi.adapter.AdapterShowListApi
import com.serasa.login_serasa.loginConsumindoApi.model.Name
import com.serasa.login_serasa.loginConsumindoApi.model.User

class ExibindoListaApi : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibindo_user_da_api)



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setInformationScreen()

    }

    fun setInformationScreen() {
        val user = intent.getSerializableExtra("passando-user") as? User

        findViewById<TextView>(R.id.textViewFirstNameDetail).apply {
            text = "Nome: ${user?.name?.firstname}"
        }
        findViewById<TextView>(R.id.textViewLasttNameDetail).apply {
            text = user?.name?.lastname
        }
        findViewById<TextView>(R.id.textViewEmailDetail).apply {
            text = "Email: ${user?.email}"
        }
        findViewById<TextView>(R.id.textViewCityDetail).apply {
            text = "City: ${user?.address?.city}"
        }
        findViewById<TextView>(R.id.textViewStreetDetail).apply {
            text = "Street: ${user?.address?.street}"
        }
        findViewById<TextView>(R.id.textViewNumberDetail).apply {
            text = "Number: ${user?.address?.number.toString()}"
        }
        findViewById<TextView>(R.id.textViewZipCodeDetail).apply {
            text = "Zipcode: ${user?.address?.zipcode}"
        }
        findViewById<TextView>(R.id.textViewLatitudeDetail).apply {
            text = "Latitude: ${user?.address?.geolocation?.lat}"
        }
        findViewById<TextView>(R.id.textViewLongitudeDetail).apply {
            text = "Longitude: ${user?.address?.geolocation?.long}"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}