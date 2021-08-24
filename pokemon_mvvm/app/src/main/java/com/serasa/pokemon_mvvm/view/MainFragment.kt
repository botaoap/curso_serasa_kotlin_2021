package com.serasa.pokemon_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.serasa.pokemon_mvvm.R
import com.serasa.pokemon_mvvm.adapter.AdapterPokemon
import com.serasa.pokemon_mvvm.databinding.MainFragmentBinding
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private var adapter = AdapterPokemon()

    private val observerPokemon = Observer<List<Pokemon>> { pokemon ->
        adapter.refresh(pokemon)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.recyclerViewListOfPokemon.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewListOfPokemon.adapter = adapter

        viewModel.pokeResponse.observe(viewLifecycleOwner, observerPokemon)
        viewModel.fetchAllFromDataBase(requireContext())
    }

}