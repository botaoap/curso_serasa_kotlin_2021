package com.serasa.exercise_firebase_mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.databinding.SignInFragmentBinding
import com.serasa.exercise_firebase_mvvm.utils.hideKeyboard
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.SignInViewModel

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var binding: SignInFragmentBinding
    private lateinit var viewModel: SignInViewModel

    private val observerUser = Observer<FirebaseUser?> {
        requireActivity().replaceView(MainFragment.newInstance())
    }

    private val observerError = Observer<String?> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = SignInFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        /**
         *  Verification on Button
         */
        view.findViewById<Button>(R.id.buttonSignIn).setOnClickListener {

            if (!binding.editTextInputEmailSignIn.text.isNullOrEmpty() &&
                !binding.editTextInputPasswordSignIn.text.isNullOrEmpty()) {
                viewModel.signIn(
                    binding.editTextInputEmailSignIn.text.toString(),
                    binding.editTextInputPasswordSignIn.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.newAccountTextView).setOnClickListener {
            requireActivity().replaceView(SignUpFragment.newInstance())
        }
    }

}