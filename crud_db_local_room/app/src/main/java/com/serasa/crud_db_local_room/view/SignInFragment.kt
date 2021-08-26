package com.serasa.crud_db_local_room.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.SignInFragmentBinding
import com.serasa.crud_db_local_room.utils.hideKeyboard
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view_model.SignInViewModel

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var binding: SignInFragmentBinding
    private lateinit var viewModel: SignInViewModel

    private val observerUser = Observer<FirebaseUser> {
        requireActivity().replaceView(MainFragment.newInstance())
    }

    private val observerError = Observer<String> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = SignInFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        binding.buttonSignIn.setOnClickListener {
            if (!binding.editTextInputEmailSignIn.text.isNullOrEmpty() &&
                !binding.editTextInputPasswordSignIn.text.isNullOrEmpty()) {
                viewModel.signIn(
                    binding.editTextInputEmailSignIn.text.toString(),
                    binding.editTextInputPasswordSignIn.text.toString()
                )
            }
        }

        binding.textViewCreateAccount.setOnClickListener {
            requireActivity().replaceView(SignUpFragment.newInstance())
        }
    }

}