package com.serasa.architecture_mvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.architecture_mvvm.R
import com.serasa.architecture_mvvm.adapter.AdapterArticle
import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewmodel : MainViewModel
    private lateinit var articleRecyclerView: RecyclerView
    private var adapter = AdapterArticle {

    }

    private val articleObserver = Observer<List<Article>> { newList ->
        adapter.refresh(newList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleRecyclerView = view.findViewById(R.id.recyclerViewArticle)
        articleRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        articleRecyclerView.adapter = adapter

        viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.articles.observe(viewLifecycleOwner, articleObserver)
        viewmodel.fetchArticle()

    }




}