package com.serasa.login_serasa.conexoesApi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.conexoesApi.ConnectionRetrofit
import com.serasa.login_serasa.conexoesApi.adapterApi.ListaApiAdapter
import com.serasa.login_serasa.conexoesApi.dataClassApi.OutApi
import com.serasa.login_serasa.conexoesApi.interfaceApi.Endpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LayoutApiActivity : AppCompatActivity() {

    private lateinit var listOfApiRecyclerView : RecyclerView
    private lateinit var adapter : ListaApiAdapter
    private lateinit var progressBar : ProgressBar
    private lateinit var errorMessage : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_api)


        connectAdapterToList()
        getDataFromApi()
    }

    fun connectAdapterToList() {
        adapter = ListaApiAdapter(mutableListOf())
        progressBar = findViewById(R.id.progressBarLoader)
        errorMessage = findViewById(R.id.texteViewMessageError)

        listOfApiRecyclerView = findViewById(R.id.recyclerViewListApi)
        listOfApiRecyclerView.layoutManager =  LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        listOfApiRecyclerView.adapter = adapter

    }


    fun getDataFromApi() {

        val retrofitClient = ConnectionRetrofit
            .getRetrofitInstance("https://parallelum.com.br")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callBack = endpoint.getMarcaCarro()


        callBack.enqueue(object : Callback<List<OutApi>> {
            override fun onFailure(call: Call<List<OutApi>>, t: Throwable) {
                progressBar.visibility = View.GONE
                errorMessage.visibility = View.VISIBLE
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                println("Falha na conexao")
            }

            override fun onResponse(call: Call<List<OutApi>>, response: Response<List<OutApi>>) {
                println("Sucesso na conexao")
                progressBar.visibility = View.GONE
                response.body()?.apply {
                    adapter.atualizarLista(this.sortedBy { it.code })
                }
            }

        })
    }

}