package com.serasa.login_serasa.loginConsumindoApiWithToken.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.serasa.login_serasa.R
import com.serasa.login_serasa.loginConsumindoApiWithToken.extension.snackBar
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products
import com.serasa.login_serasa.loginConsumindoApiWithToken.serviceApi.RetrofitBuilders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailOneProductOfListActivity : AppCompatActivity(), Callback<Products> {

    private lateinit var titleProduct: TextView
    private lateinit var categoryProduct: TextView
    private lateinit var descriptionProduct: TextView
    private lateinit var priceProduct: TextView
    private lateinit var imageproduct: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var textError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_one_product_of_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadComponents()
        connectionToApiListOfProduct()

    }

    fun loadComponents() {
        titleProduct = findViewById<TextView>(R.id.textViewTitleProductDetail)
        categoryProduct = findViewById<TextView>(R.id.textViewCategoryProductDetail)
        descriptionProduct = findViewById<TextView>(R.id.textViewDescriptionProductDetail)
        priceProduct = findViewById<TextView>(R.id.textViewPriceProductDetail)
        imageproduct = findViewById<ImageView>(R.id.imageViewAvatarProductDetail)
        progressBar = findViewById<ProgressBar>(R.id.progressBarLoaderProductDetail)
        textError = findViewById<TextView>(R.id.texteViewMessageErrorProductDetail)

    }

    fun connectionToApiListOfProduct() {
        intent.getStringExtra("chave_product")?.let { code ->
            RetrofitBuilders
                .getAuthenticationServices()
                .getProductId(code.toInt())
                .clone()
                .enqueue(this)
        }
    }

    private fun bind(product: Products) {
        titleProduct.text = product.title
        categoryProduct.text = product.category
        descriptionProduct.text = product.description
        priceProduct.text = "R$ ${product.price.toString()}"
        Glide.with(this)
            .load(product.image)
            .placeholder(R.drawable.ic_baseline_error_24)
            .into(imageproduct)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onResponse(call: Call<Products>, response: Response<Products>) {
        response.body()?.apply {
            progressBar.visibility = View.GONE
            bind(this)
        }
    }

    override fun onFailure(call: Call<Products>, t: Throwable) {
        progressBar.visibility = View.GONE
        textError.visibility = View.VISIBLE
        snackBar(titleProduct, R.string.usuario_invalido)
    }


}