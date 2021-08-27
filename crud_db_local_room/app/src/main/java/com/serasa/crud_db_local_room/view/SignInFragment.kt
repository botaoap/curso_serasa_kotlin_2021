package com.serasa.crud_db_local_room.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.serasa.crud_db_local_room.MainActivity
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.MainActivityBinding
import com.serasa.crud_db_local_room.databinding.SignInFragmentBinding
import com.serasa.crud_db_local_room.utils.hideKeyboard
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view_model.SignInViewModel

class SignInFragment : Fragment(R.layout.sign_in_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var binding: SignInFragmentBinding
    private lateinit var bindingActivity: MainActivityBinding
    private lateinit var viewModel: SignInViewModel

    private val observerUser = Observer<FirebaseUser> {
        requireActivity().replaceView(CategoryFragment.newInstance())

    }

    private val observerError = Observer<String> {
        requireActivity().hideKeyboard()
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as? MainActivity)?.hideBottomBar(false)

        binding = SignInFragmentBinding.bind(view)
        bindingActivity = MainActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        binding.buttonSignIn.setOnClickListener {
            (requireActivity() as? MainActivity)?.hideBottomBar(true)
            if (!binding.editTextInputEmailSignIn.text.isNullOrEmpty() &&
                !binding.editTextInputPasswordSignIn.text.isNullOrEmpty())
            {
                viewModel.signIn(
                    binding.editTextInputEmailSignIn.text.toString(),
                    binding.editTextInputPasswordSignIn.text.toString()
                )
            }
        }

        binding.textViewCreateAccount.setOnClickListener {
            requireActivity().replaceView(SignUpFragment.newInstance())
        }

        view.setOnClickListener {
            requireActivity().hideKeyboard()
            binding.editTextInputEmailSignIn.clearFocus()
            binding.editTextInputPasswordSignIn.clearFocus()
        }
    }

}