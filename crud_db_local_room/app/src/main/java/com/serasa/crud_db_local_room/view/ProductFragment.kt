package com.serasa.crud_db_local_room.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.adapter.AdapterProduct
import com.serasa.crud_db_local_room.databinding.AlertDialogProductBinding
import com.serasa.crud_db_local_room.databinding.ProductFragmentBinding
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.ProductWithCategory
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository
import com.serasa.crud_db_local_room.utils.hideKeyboard
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view_model.ProductViewModel
import android.view.ViewGroup


class ProductFragment : Fragment(R.layout.product_fragment), AdapterView.OnItemSelectedListener {

    companion object {
        fun newInstance() = ProductFragment()
    }

    private lateinit var viewModel: ProductViewModel
    private lateinit var binding: ProductFragmentBinding
    private lateinit var bindingAlertDialog: AlertDialogProductBinding
    private lateinit var adapter: AdapterProduct
    private lateinit var recyclerViewProduct: RecyclerView
    private val auth = AuthenticantionRepository()
    private lateinit var selectedCategory: Category

    private val observerProduct = Observer<List<ProductWithCategory>> {
        adapter.refresh(it)
    }

    private val observerCategory = Observer<List<Category>> {

    }

    private val observerError = Observer<String> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ProductFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        recyclerViewProduct = binding.recyclerViewListProduct
        adapter = AdapterProduct { product, isDelete ->
            if (isDelete) {
                AlertDialog.Builder(requireContext()) // set message, title, and icon
                    .setTitle("Delete")
                    .setMessage("Do you want to Delete")
                    .setIcon(R.drawable.ic_delete)
                    .setPositiveButton("Delete",
                        DialogInterface.OnClickListener { dialog, whichButton -> //your deleting code
                            viewModel.deleteIntoDBProduct(product, requireContext())
                            dialog.dismiss()
                        })
                    .setNegativeButton("cancel",
                        DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                    .create()
                    .show()
            } else {


                layoutInflater.inflate(R.layout.alert_dialog_product, null).apply {
                    bindingAlertDialog = AlertDialogProductBinding.bind(this)
                }
                bindingAlertDialog.editTextProductAlertDialog.hint = product.product?.name
                bindingAlertDialog.editTextProductPriceAlertDialog.hint = product.product?.price.toString()
                AlertDialog.Builder(requireContext())
                    .setTitle("Edit your Product")
                    .setView(bindingAlertDialog.root)
                    .setPositiveButton("Edit",
                        DialogInterface.OnClickListener { dialog, which ->
                            viewModel.updateIntoDBProduct(
                                bindingAlertDialog.editTextProductAlertDialog.text.toString(),
                                bindingAlertDialog.editTextProductPriceAlertDialog.text.toString().toDouble(),
                                product.product?.id!!,
                                requireContext()
                            )
                        })
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, which ->
                            dialog.cancel()
                        })
                    .create()
                    .show()
            }
        }

        recyclerViewProduct.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewProduct.adapter = adapter


        viewModel.product.observe(viewLifecycleOwner, observerProduct)
        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.category.observe(viewLifecycleOwner, observerCategory)

        viewModel.getProducts(requireContext())

        val spinner: Spinner = binding.spinnerCategory

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            viewModel.getCategory(requireContext())
        ).also { adapterSpinner ->
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapterSpinner
            spinner.onItemSelectedListener = this
        }

        binding.buttonADDProduct.setOnClickListener {
            requireActivity().hideKeyboard()
            if (!binding.editTextInputProduct.text.isNullOrEmpty() &&
                !binding.editTextInputProductPrice.text.isNullOrEmpty()
            ) {
                viewModel.insertIntoDBProduct(
                    binding.editTextInputProduct.text.toString(),
                    binding.editTextInputProductPrice.text.toString().toDouble(),
                    selectedCategory.id,
                    requireContext()
                )
            }
            binding.editTextInputProduct.setText("")
            binding.editTextInputProductPrice.setText("")
            binding.editTextInputProduct.requestFocus()

        }

        binding.imageViewLogOutMainProduct.setOnClickListener {
            auth.signOut()
            requireActivity().replaceView(SignInFragment.newInstance())
        }

        view.setOnClickListener {
            requireActivity().hideKeyboard()
        }


    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        idCategory: Long
    ) {
        selectedCategory = parent?.getItemAtPosition(position) as Category
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}