package com.serasa.login_serasa.loginConsumindoApi.model

import java.io.Serializable

data class Address(

    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String

) : Serializable