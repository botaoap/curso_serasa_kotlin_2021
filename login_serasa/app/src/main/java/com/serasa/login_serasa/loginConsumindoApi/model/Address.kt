package com.serasa.login_serasa.loginConsumindoApi.model

data class Address(

    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String

)