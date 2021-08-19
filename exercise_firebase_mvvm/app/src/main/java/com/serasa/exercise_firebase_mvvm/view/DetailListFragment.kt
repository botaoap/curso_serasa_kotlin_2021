package com.serasa.exercise_firebase_mvvm.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.databinding.DetailListFragmentBinding
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.DetailListViewModel

class DetailListFragment : Fragment(R.layout.detail_list_fragment) {

    companion object {
        fun newInstance() = DetailListFragment()
    }

    private lateinit var binding: DetailListFragmentBinding
    private lateinit var viewModel: DetailListViewModel
    private var billTeste : Bill? = null
    private var uidPutString: String? = null

    private val observerUid = Observer<String> {

    }

    private val observerOndeBill = Observer<Bill> {
        billTeste = it
        bind(it)
    }

    private val observerDelete = Observer<Boolean> {

    }

    private val observerUpdate = Observer<Boolean> {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString("key_uid")?.apply {
            uidPutString = this
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DetailListFragmentBinding.bind(view)

        loadViewModel(view)

        view.findViewById<View>(R.id.imageViewDetailArrowback).setOnClickListener {
            requireActivity().replaceView(MainFragment.newInstance())
        }

    }

    fun loadViewModel(view: View) {



        viewModel = ViewModelProvider(this).get(DetailListViewModel::class.java)

        viewModel.uid.observe(viewLifecycleOwner, observerUid)
        viewModel.bill.observe(viewLifecycleOwner, observerOndeBill)
        viewModel.delete.observe(viewLifecycleOwner, observerDelete)

        viewModel.fetchOneBill(uidPutString!!)
        viewModel.fetchBillOndeId(uidPutString!!)

        binding.buttonDetailDelete.setOnClickListener {
            viewModel.deleteBill(uidPutString!!)
            requireActivity().replaceView(MainFragment.newInstance())
        }

        binding.buttonDetailUpdate.setOnClickListener {
            binding.editTextDetailName.visibility = View.VISIBLE
            binding.editTextDetailPrice.visibility = View.VISIBLE
            binding.buttonDetailSave.visibility = View.VISIBLE
            binding.textViewDetailName.visibility = View.INVISIBLE
            binding.textViewDetailPrice.visibility = View.INVISIBLE
            binding.buttonDetailUpdate.visibility = View.INVISIBLE


        }

        binding.buttonDetailSave.setOnClickListener {
            billTeste?.name = binding.editTextDetailName.text.toString()
            billTeste?.price = binding.editTextDetailPrice.text.toString().toDouble()

            viewModel.updateBill(billTeste!!)
            requireActivity().replaceView(MainFragment.newInstance())
        }

    }

    fun bind(bill: Bill) {
        binding.textViewDetailUid.text = bill.uid
        binding.textViewDetailName.text = bill.name
        binding.textViewDetailPrice.text = "R$ ${bill.price.toString()}"
        binding.editTextDetailName.setHint(bill.name)
        binding.editTextDetailPrice.setHint(bill.price.toString())
    }

}