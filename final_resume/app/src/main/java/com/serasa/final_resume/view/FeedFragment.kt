package com.serasa.final_resume.view

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.serasa.final_resume.R
import com.serasa.final_resume.adapter.ImageAdapter
import com.serasa.final_resume.databinding.FeedFragmentBinding
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.util.hideKeyboard
import com.serasa.final_resume.view_model.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.feed_fragment) {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding: FeedFragmentBinding
    private var page: Int = 1
    private var adapterImage = ImageAdapter()

    private var observerImage = Observer<List<Image>> {
        binding.progressBar.visibility = INVISIBLE
        adapterImage.refresh(it)
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchImage("",page)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        setupRecyclerView()
        loadObserver()
        executeComponents()

    }

    private fun loadObserver() {
        viewModel.image.observe(viewLifecycleOwner, observerImage)
    }

    private fun loadComponents(view: View) {
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
    }

    private fun setupRecyclerView() = with(binding.recyclerViewImage) {
        adapter = adapterImage
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    binding.progressBar.visibility = VISIBLE
//                    if (feedType == FeedType.VIDEO) {
//                        viewModel.fetchVideo(q = search, page = page++)
//                    }
//                    else
                    viewModel.fetchImage("", page = page++)
//                    viewModel.fetchImage(q = search, page = page++)
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                requireActivity().hideKeyboard()
            }
        })
    }

    private fun executeComponents() {

        binding.buttonGoToDetail.setOnClickListener {
            findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToDetailFragment())
        }
    }
}