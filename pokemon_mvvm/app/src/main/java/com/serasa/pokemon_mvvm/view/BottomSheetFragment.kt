package com.serasa.pokemon_mvvm.view

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.serasa.pokemon_mvvm.R
import com.serasa.pokemon_mvvm.adapter.AdapterTypesWeaknesses
import com.serasa.pokemon_mvvm.databinding.BottomSheetFragmentBinding
import com.serasa.pokemon_mvvm.model.relatedTypes
import com.serasa.pokemon_mvvm.view_model.BottomSheetViewModel

class BottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = BottomSheetFragment()
    }

    private lateinit var binding: BottomSheetFragmentBinding
    private lateinit var viewModel: BottomSheetViewModel
    private lateinit var recyclerViewIconTypeWeaknesses: RecyclerView
    private lateinit var adapter: AdapterTypesWeaknesses

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter =  AdapterTypesWeaknesses()
        binding = BottomSheetFragmentBinding.bind(view)
        recyclerViewIconTypeWeaknesses = binding.recyclerViewTypes

        recyclerViewIconTypeWeaknesses.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewIconTypeWeaknesses.adapter = adapter

        adapter.refresh(relatedTypes.values().toList())
    }



    override fun getTheme() = R.style.CustomBottomSheetDialog

}