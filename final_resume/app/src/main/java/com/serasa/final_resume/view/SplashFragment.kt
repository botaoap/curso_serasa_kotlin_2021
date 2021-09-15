package com.serasa.final_resume.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.serasa.final_resume.MainActivity
import com.serasa.final_resume.MainActivity_GeneratedInjector
import com.serasa.final_resume.R
import com.serasa.final_resume.databinding.SplashFragmentBinding
import com.serasa.final_resume.model.Image
import com.serasa.final_resume.view_model.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_fragment) {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: SplashFragmentBinding

    private val observerImageFromApi = Observer<List<Image>> {
        viewModel.insert(it)
    }

//    private val observerImageFromDb = Observer<List<Image>> {
//        if (it.isEmpty()) {
//            viewModel.fetchImage("", 1)
//        }
//        viewModel.fetchImageFromDb()
//    }

    private val observerInsertImage = Observer<Boolean> {
        if(it) {
            findNavController().apply {
                popBackStack(R.id.splashFragment, true)
                navigate(R.id.feedFragment)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchImage("", 1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        setupObserver()
        (requireActivity() as? MainActivity)?.supportActionBar?.hide()

    }

    private fun loadComponents(view: View) {
        binding = SplashFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.image.observe(viewLifecycleOwner, observerImageFromApi)
//        viewModel.imageDb.observe(viewLifecycleOwner, observerImageFromDb)
        viewModel.insert.observe(viewLifecycleOwner, observerInsertImage)

    }



}