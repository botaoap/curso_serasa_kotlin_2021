package com.serasa.login_serasa.conexoesApi.interfaceApi

import com.serasa.login_serasa.conexoesApi.dataClassApi.OutApi
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("/fipe/api/v1/carros/marcas")
    fun getMarcaCarro() : Call<List<OutApi>>
}