package com.serasa.exercise_firebase_mvvm.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.DetailListViewModel

class DetailListFragment : Fragment(R.layout.detail_list_fragment) {

    companion object {
        fun newInstance() = DetailListFragment()
    }

    private lateinit var viewModel: DetailListViewModel
    private lateinit var uidTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonUpdate: Button
    private var billTeste : Bill? = null
    private var uidPutString: String? = null

    private val observerUid = Observer<String> {
        uidPutString
    }

    private val observerOndeBill = Observer<Bill> {
        billTeste = it
        bind(it)
    }

    private val observerDelete = Observer<Boolean> {
        uidPutString
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

        loadViewModel(view)

        loadComponents(view)

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

        view.findViewById<Button>(R.id.buttonDetailDelete).setOnClickListener {
            viewModel.deleteBill(uidPutString!!)
            requireActivity().replaceView(MainFragment.newInstance())
        }

        view.findViewById<Button>(R.id.buttonDetailUpdate).setOnClickListener {
            nameEditText.visibility = View.VISIBLE
            priceEditText.visibility = View.VISIBLE
            buttonSave.visibility = View.VISIBLE
            nameTextView.visibility = View.INVISIBLE
            priceTextView.visibility = View.INVISIBLE
            buttonUpdate.visibility = View.INVISIBLE


        }

        view.findViewById<Button>(R.id.buttonDetailSave).setOnClickListener {

            billTeste?.name = nameEditText.text.toString()
            billTeste?.price = priceEditText.text.toString().toDouble()

            viewModel.updateBill(billTeste!!)
            requireActivity().replaceView(MainFragment.newInstance())
        }

    }

    fun loadComponents(view: View) {
        uidTextView = view.findViewById(R.id.textViewDetailUid)
        nameTextView = view.findViewById(R.id.textViewDetailName)
        priceTextView = view.findViewById(R.id.textViewDetailPrice)
        nameEditText = view.findViewById(R.id.editTextDetailName)
        priceEditText = view.findViewById(R.id.editTextDetailPrice)
        buttonSave = view.findViewById(R.id.buttonDetailSave)
        buttonUpdate = view.findViewById(R.id.buttonDetailUpdate)
    }

    fun bind(bill: Bill) {
        uidTextView.text = bill.uid
        nameTextView.text = bill.name
        priceTextView.text = "R$ ${bill.price.toString()}"
        nameEditText.setText(bill.name)
        priceEditText.setText(bill.price.toString())
    }

}