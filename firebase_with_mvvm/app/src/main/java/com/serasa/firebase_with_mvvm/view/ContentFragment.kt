package com.serasa.firebase_with_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.firebase_with_mvvm.R
import com.serasa.firebase_with_mvvm.adapter.AdapterBill
import com.serasa.firebase_with_mvvm.model.Bill
import com.serasa.firebase_with_mvvm.view_model.ContentViewModel

class ContentFragment : Fragment(R.layout.content_fragment) {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var viewModel: ContentViewModel
    private lateinit var listBilRecyclerView : RecyclerView
    private val adapter = AdapterBill()

    val observerBill = Observer<List<Bill>> {
        adapter.refresh(it)
    }

    val observerError = Observer<String> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listBilRecyclerView = view.findViewById(R.id.recyclerViewListBill)
        listBilRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        listBilRecyclerView.adapter = adapter


        viewModel = ViewModelProvider(this).get(ContentViewModel::class.java)

        viewModel.bill.observe(viewLifecycleOwner, observerBill)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        viewModel.fetchBill()



    }

}