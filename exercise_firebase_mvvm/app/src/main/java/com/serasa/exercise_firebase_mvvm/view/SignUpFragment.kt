package com.serasa.exercise_firebase_mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.SignUpViewModel

class SignUpFragment : Fragment(R.layout.sign_up_fragment) {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    private val observerNewUser = Observer<FirebaseUser?> {
        Snackbar.make(requireView(), "Account created", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerNewUser)

        view.findViewById<Button>(R.id.buttonSignUp).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.editTextInputEmailSignUp)
            val inputPassword = view.findViewById<EditText>(R.id.editTextInputPasswordSignUp)

            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.createNewAccount(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.imageViewArrowBack).setOnClickListener {
            requireActivity().replaceView(SignInFragment.newInstance())
        }
    }

}