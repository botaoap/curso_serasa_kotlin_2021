package com.serasa.dependency_injection_users_github.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.UserHandle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.dependency_injection_users_github.R
import com.serasa.dependency_injection_users_github.adapater.AdapterUser
import com.serasa.dependency_injection_users_github.databinding.MainFragmentBinding
import com.serasa.dependency_injection_users_github.model.User
import com.serasa.dependency_injection_users_github.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: AdapterUser
    private lateinit var recyclerView: RecyclerView

    private val observerUser = Observer<List<User>> {
        adapter.refresh(it)
    }
    private val observerPage = Observer<Int> {

    }
    private val observerError = Observer<String> {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        executeComponents()
    }

    fun loadComponents(view: View) {
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = AdapterUser()
        recyclerView = binding.recyclerViewUsers

        viewModel.user.observe(viewLifecycleOwner, observerUser)
        viewModel.page.observe(viewLifecycleOwner, observerPage)
        viewModel.error.observe(viewLifecycleOwner, observerError)

    }

    fun executeComponents() {
        viewModel.fetchUser()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }

}