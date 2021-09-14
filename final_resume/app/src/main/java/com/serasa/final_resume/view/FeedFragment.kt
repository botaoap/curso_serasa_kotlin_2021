package com.serasa.final_resume.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.FeedFragmentBinding
import com.serasa.final_resume.view_model.FeedViewModel

class FeedFragment : Fragment(R.layout.feed_fragment) {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding: FeedFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        binding.buttonGoToDetail.setOnClickListener {
            findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToDetailFragment())
        }
    }
}