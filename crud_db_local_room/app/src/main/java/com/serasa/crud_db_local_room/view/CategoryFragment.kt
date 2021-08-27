package com.serasa.crud_db_local_room.view

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serasa.crud_db_local_room.adapter.AdapterCategory
import com.serasa.crud_db_local_room.databinding.CategoryFragmentBinding
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.utils.hideKeyboard
import com.serasa.crud_db_local_room.view_model.CategoryViewModel
import android.content.DialogInterface
import com.serasa.crud_db_local_room.R


class CategoryFragment : Fragment(R.layout.category_fragment) {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private lateinit var binding: CategoryFragmentBinding
    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: AdapterCategory
    private lateinit var recyclerViewCategory: RecyclerView


    private val observerCategory = Observer<List<Category>> {
        adapter.refresh(it)

    }

    private val observerError = Observer<String> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CategoryFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        adapter = AdapterCategory(){ category, imagem ->
            imagem.setOnClickListener {

                AlertDialog.Builder(requireContext()) // set message, title, and icon
                    .setTitle("Delete")
                    .setMessage("Do you want to Delete")
                    .setIcon(R.drawable.ic_delete)
                    .setPositiveButton("Delete",
                        DialogInterface.OnClickListener { dialog, whichButton -> //your deleting code
                            viewModel.deleteIntoDB(category, requireContext())
                            dialog.dismiss()
                        })
                    .setNegativeButton("cancel",
                        DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                    .create()
                    .show()
            }
        }

        recyclerViewCategory = binding.recyclerViewListCategory
        recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewCategory.adapter = adapter

        viewModel.category.observe(viewLifecycleOwner, observerCategory)
        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.getCategories(requireContext())


        binding.buttonADDCategory.setOnClickListener {
            if (!binding.editTextInputCategory.text.isNullOrEmpty()) {
                viewModel.insertIntopDB(
                    binding.editTextInputCategory.text.toString(),
                    requireContext()
                )
            }
            binding.editTextInputCategory.setText("")
            binding.editTextInputCategory.clearFocus()
            requireActivity().hideKeyboard()
        }


    }
}