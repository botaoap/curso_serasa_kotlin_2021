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
import com.serasa.exercise_firebase_mvvm.databinding.SignUpFragmentBinding
import com.serasa.exercise_firebase_mvvm.utils.hideKeyboard
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.SignUpViewModel

class SignUpFragment : Fragment(R.layout.sign_up_fragment) {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel

    private val observerNewUser = Observer<FirebaseUser?> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), "Account created", Snackbar.LENGTH_LONG).show()
        requireActivity().replaceView(SignInFragment.newInstance())
    }

    private val observerError = Observer<String?> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = SignUpFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerNewUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        view.findViewById<Button>(R.id.buttonSignUp).setOnClickListener {

            if (!binding.editTextInputEmailSignUp.text.isNullOrEmpty() &&
                !binding.editTextInputPasswordSignUp.text.isNullOrEmpty()) {
                viewModel.createNewAccount(
                    binding.editTextInputEmailSignUp.text.toString(),
                    binding.editTextInputPasswordSignUp.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.imageViewArrowBack).setOnClickListener {
            requireActivity().replaceView(SignInFragment.newInstance())
        }
    }

}