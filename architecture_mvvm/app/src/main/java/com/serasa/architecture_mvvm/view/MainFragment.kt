package com.serasa.architecture_mvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.snackbar.Snackbar
import com.serasa.architecture_mvvm.R
import com.serasa.architecture_mvvm.adapter.AdapterArticle
import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel : MainViewModel
    private lateinit var articleRecyclerView: RecyclerView
    private var adapter = AdapterArticle {

    }

    private val articleObserver = Observer<List<Article>> { newList ->
        adapter.refresh(newList)
    }

    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleRecyclerView = view.findViewById(R.id.recyclerViewArticle)
        articleRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        articleRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.articles.observe(viewLifecycleOwner, articleObserver)
        viewModel.error.observe(viewLifecycleOwner, errorObserver)
        viewModel.fetchArticle()

    }




}