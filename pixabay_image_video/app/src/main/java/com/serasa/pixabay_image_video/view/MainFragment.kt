package com.serasa.pixabay_image_video.view

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.adapter.PixabayImageAdapter
import com.serasa.pixabay_image_video.databinding.MainFragmentBinding
import com.serasa.pixabay_image_video.model.Image
import com.serasa.pixabay_image_video.utils.hideKeyboard
import com.serasa.pixabay_image_video.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: PixabayImageAdapter
    private lateinit var recyclerView: RecyclerView
    private var page: Int = 1
    private var search: String = "sol"

    private val observerImage = Observer<List<Image>> {
        binding.progressBar.visibility = INVISIBLE
        adapter.submitList(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        executeComponents()
        loadMoreImage()
    }

    fun loadComponents(view: View) {
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = PixabayImageAdapter()
        recyclerView = binding.recyclerViewImage
    }

    fun executeComponents() {

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.image.observe(viewLifecycleOwner, observerImage)

        viewModel.fetchImage(q = search, page = page)

    }

    fun loadMoreImage() {
//        binding.recyclerViewImage.onScrollStateChanged(SCROLL_STATE_DRAGGING).apply {
//            binding.progressBar.visibility = VISIBLE
//            viewModel.fetchImage(q = "sol", page = page++)
//
//        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                requireActivity().hideKeyboard()
                super.onScrolled(recyclerView, dx, dy)
                if(!recyclerView.canScrollVertically(1)) {
                    binding.progressBar.visibility = VISIBLE
                    viewModel.fetchImage(q = search, page = page++)
                }
            }
        })
    }



}