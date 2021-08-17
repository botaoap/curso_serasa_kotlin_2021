package com.serasa.firebase_with_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.firebase_with_mvvm.MainActivity
import com.serasa.firebase_with_mvvm.R
import com.serasa.firebase_with_mvvm.utils.replaceView
import com.serasa.firebase_with_mvvm.view_model.SignInViewModel

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    private val observerUser = Observer<FirebaseUser?> {
        requireActivity().replaceView(MainFragment.newInstance())
    }
    private val observerError = Observer<String?> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.inputEmailEditTextSignIn)
            val inputPassword = view.findViewById<EditText>(R.id.inputPasswordEditTextSignIn)

            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.signIn(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }
        view.findViewById<View>(R.id.newAccountTextView).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(MainFragment.newInstance())
        }
    }
}