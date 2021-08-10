package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApiWithToken.AdapterRecyclerViewListOfProducts
import com.serasa.login_serasa.loginConsumindoApiWithToken.extension.snackBar
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products
import com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi.RetrofitBuilders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListOfProductActivity() : AppCompatActivity(), Callback<List<Products>> {

    private lateinit var adapter: AdapterRecyclerViewListOfProducts
    private lateinit var showRecyclerViewProducts: RecyclerView
    private lateinit var error: View
    private lateinit var progressBar: ProgressBar
    private lateinit var textError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user_token)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadComponents()
        showListOfProducts()
        getConnectionWithListOfProducts()

    }

    fun loadComponents() {
        progressBar = findViewById<ProgressBar>(R.id.progressBarLoaderListOfProduct)
        textError = findViewById<TextView>(R.id.texteViewMessageErrorListOfProduct)
    }

    fun showListOfProducts() {

        adapter = AdapterRecyclerViewListOfProducts(){ product ->

            Intent(this, DetailOneProductOfListActivity::class.java).apply {
                putExtra("chave_product", product.id)
                startActivity(this)
            }
        }
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
            progressBar.visibility = View.GONE
            adapter.refreshList(this)
        }
    }

    override fun onFailure(call: Call<List<Products>>, t: Throwable) {
        println("Erro ao carregar Lista")
        progressBar.visibility = View.GONE
        textError.visibility = View.VISIBLE
        snackBar(error, R.string.usuario_invalido)
    }

}

