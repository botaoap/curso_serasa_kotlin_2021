package com.serasa.final_resume.view

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.AccountFragmentBinding
import com.serasa.final_resume.view_model.AccountViewModel

class AccountFragment : Fragment(R.layout.account_fragment) {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel
    private lateinit var binding: AccountFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AccountFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        binding.buttonAccountGoToFeed.setOnClickListener {
            findNavController().let {
                it.navigate(R.id.action_accountFragment_to_feedFragment)
            }
        }
    }
}