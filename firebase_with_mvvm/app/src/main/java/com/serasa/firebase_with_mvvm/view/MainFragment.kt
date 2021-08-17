package com.serasa.firebase_with_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.firebase_with_mvvm.R
import com.serasa.firebase_with_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val observerNewUser = Observer<FirebaseUser?> {
        Snackbar.make(requireView(), "Account created!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerNewUser)

        view.findViewById<Button>(R.id.buttonCreateUser).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.editTextInputEmail)
            val inputPassword = view.findViewById<EditText>(R.id.editTextInputPassword)
            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.createNewAccount(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }
    }

}