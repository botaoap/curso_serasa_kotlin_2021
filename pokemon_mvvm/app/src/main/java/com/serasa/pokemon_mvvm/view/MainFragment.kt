package com.serasa.pokemon_mvvm.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.serasa.pokemon_mvvm.R
import com.serasa.pokemon_mvvm.adapter.AdapterPokemon
import com.serasa.pokemon_mvvm.databinding.MainFragmentBinding
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }
    // creating a variable for our button
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private var adapter = AdapterPokemon()

    private val observerPokemon = Observer<List<Pokemon>> { pokemon ->
        adapter.refresh(pokemon)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = binding.recyclerViewListOfPokemon
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.pokeResponse.observe(viewLifecycleOwner, observerPokemon)
        viewModel.fetchAllFromDataBase(requireContext())

        binding.editTextInputSearchField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 2) {
                        viewModel.fetchFilteredFromDataBase(requireContext(), it.toString())
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if (it.isEmpty()) {
                        viewModel.fetchAllFromDataBase(requireContext())
                    }
                }
            }

        })

        binding.imageViewFilter.setOnClickListener {
            BottomSheetFragment.newInstance().let {
                it.show(parentFragmentManager, "key_filter")
            }
        }
    }
}