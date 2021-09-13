package com.serasa.pixabay_image_video.view

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.pixabay_image_video.R
import com.serasa.pixabay_image_video.adapter.PixabayImageAdapter
import com.serasa.pixabay_image_video.adapter.PixabayVideoAdapter
import com.serasa.pixabay_image_video.adapter.SearchAdapter
import com.serasa.pixabay_image_video.databinding.ItemSearchBinding
import com.serasa.pixabay_image_video.databinding.MainFragmentBinding
import com.serasa.pixabay_image_video.model.Image
import com.serasa.pixabay_image_video.model.VideoConfig
import com.serasa.pixabay_image_video.utils.hideKeyboard
import com.serasa.pixabay_image_video.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment(private val feedType: FeedType) : Fragment(R.layout.main_fragment) {

//    companion object {
//        fun newInstance() = MainFragment()
//    }

    private var page: Int = 1
    private var search: String = ""
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var bindingSearch: ItemSearchBinding
    private lateinit var recyclerView: RecyclerView
    lateinit var adapters: ConcatAdapter
    private var adapterImage = PixabayImageAdapter()
    private var adapterVideo = PixabayVideoAdapter()
    private var adapterSearch = SearchAdapter {
//        search = it
//        viewModel.fetchImage(it, page)
        if (feedType == FeedType.VIDEO) {
            viewModel.fetchVideo(it, page)
        } else viewModel.fetchImage(it, page)
    }


    private val observerImage = Observer<List<Image>> {
        binding.progressBar.visibility = INVISIBLE
        adapterImage.submitList(it)

    }

    private val observerVideo = Observer<List<VideoConfig>> {
        binding.progressBar.visibility = INVISIBLE
        view?.findViewById<EditText>(R.id.ediTextSearchOnHeader)
            ?.setHint(R.string.type_for_search_an_video)
        adapterVideo.submitList(it)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        loadMoreImage()
    }

    private fun loadComponents(viewT: View) {
        binding = MainFragmentBinding.bind(viewT)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.image.observe(viewLifecycleOwner, observerImage)
        viewModel.video.observe(viewLifecycleOwner, observerVideo)
        recyclerView = binding.recyclerViewImage
        adapters =
            if (feedType == FeedType.VIDEO) {
                ConcatAdapter(adapterSearch, adapterVideo)
            }
            else ConcatAdapter(adapterSearch,adapterImage)
        executeComponents()
    }

    private fun executeComponents() {

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapters

        if (feedType == FeedType.VIDEO) {
            viewModel.fetchVideo(q = search, page = page)
        }
         else viewModel.fetchImage(q = search, page = page)

    }

    private fun loadMoreImage() {
        // The end of the Recycler View we Request another Search from Api but is the next page
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.progressBar.visibility = VISIBLE
                    viewModel.fetchImage(q = search, page = page++)
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                requireActivity().hideKeyboard()
            }
        })
    }

    enum class FeedType {
        VIDEO,
        IMAGE
    }
}