package com.serasa.crud_db_local_room.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.SignUpFragmentBinding
import com.serasa.crud_db_local_room.utils.hideKeyboard
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view_model.SignUpViewModel

class SignUpFragment : Fragment(R.layout.sign_up_fragment) {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var binding: SignUpFragmentBinding
    private lateinit var viewModel: SignUpViewModel

    private val observerCreateUser = Observer<FirebaseUser> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), "Account created", Snackbar.LENGTH_LONG).show()
        requireActivity().replaceView(SignInFragment.newInstance())
    }

    private val observerError = Observer<String> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = SignUpFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerCreateUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        binding.buttonSignUp.setOnClickListener {
            if (!binding.editTextInputEmailSignUp.text.isNullOrEmpty() &&
                !binding.editTextInputPasswordSignUp.text.isNullOrEmpty()){
                viewModel.createAccountWithEmailPassword(
                    binding.editTextInputEmailSignUp.text.toString(),
                    binding.editTextInputPasswordSignUp.text.toString()
                )
            }
        }

        binding.imageViewArrowBackSignUp.setOnClickListener {
            requireActivity().replaceView(SignInFragment.newInstance())
        }

        view.setOnClickListener {
            requireActivity().hideKeyboard()
            binding.editTextInputEmailSignUp.clearFocus()
            binding.editTextInputPasswordSignUp.clearFocus()
        }
    }

}