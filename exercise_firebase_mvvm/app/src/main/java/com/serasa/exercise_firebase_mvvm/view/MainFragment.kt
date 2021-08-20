package com.serasa.exercise_firebase_mvvm.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.ViewPagerActivity
import com.serasa.exercise_firebase_mvvm.adapter.AdapterCrud
import com.serasa.exercise_firebase_mvvm.databinding.MainFragmentBinding
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.utils.hideKeyboard
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
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

        binding = MainFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = binding.recyclerViewListCrud
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.user.observe(viewLifecycleOwner, observerSignUser)
        viewModel.isSignedIn.observe(viewLifecycleOwner, observerIsSignOut)
        viewModel.bill.observe(viewLifecycleOwner, observerBill)

        viewModel.fetchBill()

        binding.buttonAddList.setOnClickListener {
            requireActivity().hideKeyboard()

            if (!binding.textInputNameCrud.text.toString().isNullOrEmpty() &&
                !binding.textInputPriceCrud.text.toString().isNullOrEmpty()
            ) {
                viewModel.addBill(
                    binding.textInputNameCrud.text.toString(),
                    binding.textInputPriceCrud.text.toString().toDouble()
                )
            }
            binding.textInputNameCrud.setText("")
            binding.textInputPriceCrud.setText("")
            binding.textInputNameCrud.requestFocus()


        }

        binding.imageViewGoBackToSignIn.setOnClickListener {
            viewModel.signOut()
        }

        binding.buttonViewPage.setOnClickListener {
            Intent(context, ViewPagerActivity::class.java).apply {
                startActivity(this)

            }

        }

    }

}