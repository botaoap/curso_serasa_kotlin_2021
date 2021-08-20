package com.serasa.exercise_firebase_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.serasa.exercise_firebase_mvvm.adapter.AdapterViewPager
import com.serasa.exercise_firebase_mvvm.databinding.ViewPagerActivityBinding
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.view.ViewPagerFragment
import com.serasa.exercise_firebase_mvvm.view_model.ViewPagerViewModel

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ViewPagerActivityBinding
    private lateinit var viewModel: ViewPagerViewModel

    private val observerBill = Observer<Bill> { bill ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ViewPagerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ViewPagerViewModel::class.java)

        binding.toolBar.apply {
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        viewModel.bill.observe(this, observerBill)


        binding.viewPager.adapter = AdapterViewPager(supportFragmentManager)
        binding.tabs.setupWithViewPager(binding.viewPager)



    }

}