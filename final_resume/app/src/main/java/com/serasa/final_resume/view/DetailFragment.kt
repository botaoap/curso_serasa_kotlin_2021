package com.serasa.final_resume.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.DetailFragmentBinding
import com.serasa.final_resume.view_model.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: DetailFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.buttonGoToFeed.setOnClickListener {
            findNavController().let {
//                it.popBackStack(R.id.detailFragment, false)
//                it.navigate(R.id.action_detailFragment_to_accountFragment)
                it.popBackStack(R.id.detailFragment, true)
                it.navigate(R.id.accountFragment);

            }
        }
    }

}