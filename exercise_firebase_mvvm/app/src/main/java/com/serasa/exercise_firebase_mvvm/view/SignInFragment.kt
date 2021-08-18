package com.serasa.exercise_firebase_mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.SignInViewModel

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    private val observerUser = Observer<FirebaseUser?> {

    }

    private val observerError = Observer<String?> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        /**
         *  Verification on Button
         */
        view.findViewById<Button>(R.id.buttonSignIn).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.editTextInputEmailSignIn)
            val inputPassword = view.findViewById<EditText>(R.id.editTextInputPasswordSignIn)

            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.signIn(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }
        
        view.findViewById<View>(R.id.newAccountTextView).setOnClickListener {
            requireActivity().replaceView(SignUpFragment.newInstance())
        }
    }

}