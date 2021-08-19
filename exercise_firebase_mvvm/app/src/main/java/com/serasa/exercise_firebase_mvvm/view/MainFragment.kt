package com.serasa.exercise_firebase_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.adapter.AdapterCrud
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository
import com.serasa.exercise_firebase_mvvm.utils.hideKeyboard
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter = AdapterCrud { bill ->
//        val frag = DetailListFragment.newInstance()
//        val args = Bundle()
//        args.putString("key_uid", bill?.uid)
//        frag.arguments = args
        bill?.uid.let {

            requireActivity().replaceView(DetailListFragment.newInstance().apply {
                arguments = Bundle().apply {
                    putString("key_uid", bill?.uid)
                }
            })
        }

    }

    private var observerBill = Observer<List<Bill>> {
        adapter.refresh(it)
    }

    private var observerError = Observer<String> {

    }

    private var observerIsSignOut = Observer<Boolean> { isSignIn ->
        if (!isSignIn) {
            requireActivity().replaceView(SignInFragment.newInstance())
        }
    }

    private var observerSignUser = Observer<FirebaseUser> {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = view.findViewById(R.id.recyclerViewListCrud)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.user.observe(viewLifecycleOwner, observerSignUser)
        viewModel.isSignedIn.observe(viewLifecycleOwner, observerIsSignOut)
        viewModel.bill.observe(viewLifecycleOwner, observerBill)

        viewModel.fetchBill()

        view.findViewById<Button>(R.id.buttonAddList).setOnClickListener {
            requireActivity().hideKeyboard()
            val inputName = view.findViewById<EditText>(R.id.textInputNameCrud)
            val inputPrice = view.findViewById<EditText>(R.id.textInputPriceCrud)

            if (!inputName.text.toString().isNullOrEmpty() && !inputPrice.text.toString()
                    .isNullOrEmpty()
            ) {
                viewModel.addBill(
                    inputName.text.toString(),
                    inputPrice.text.toString().toDoubleOrNull()
                )
            }

        }

        view.findViewById<View>(R.id.imageViewGoBackToSignIn).setOnClickListener {
            viewModel.signOut()
        }


    }

}