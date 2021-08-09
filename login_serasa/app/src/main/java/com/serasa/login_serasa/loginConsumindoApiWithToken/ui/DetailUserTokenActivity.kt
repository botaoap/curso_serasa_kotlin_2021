package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApiWithToken.AdapterRecyclerViewListOfProducts
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products
import com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi.RetrofitBuilders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserTokenActivity() : AppCompatActivity(), Callback<List<Products>> {

    private lateinit var titleProduct: TextView
    private lateinit var categoryProduct: TextView
    private lateinit var descriptionProduct: TextView
    private lateinit var priceProduct: TextView
    private lateinit var imageproduct: ImageView
    private lateinit var adapter: AdapterRecyclerViewListOfProducts
    private lateinit var showRecyclerViewProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user_token)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showListOfProducts()
        getConnectionWithListOfProducts()
    }

    fun showListOfProducts() {

        adapter = AdapterRecyclerViewListOfProducts(mutableListOf())

        showRecyclerViewProducts = findViewById<RecyclerView>(R.id.recyclerViewListOfProducts)
        showRecyclerViewProducts.layoutManager =
            GridLayoutManager(this, 2)
        showRecyclerViewProducts.adapter = adapter

    }

    fun getConnectionWithListOfProducts() {
        RetrofitBuilders
            .getAuthenticationServices()
            .getAllProducts()
            .clone()
            .enqueue(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
        println("Lista Carregada")
        response.body()?.apply {
            adapter.refreshList(this)
        }
    }

    override fun onFailure(call: Call<List<Products>>, t: Throwable) {
        println("Erro ao carregar Lista")
    }

}

