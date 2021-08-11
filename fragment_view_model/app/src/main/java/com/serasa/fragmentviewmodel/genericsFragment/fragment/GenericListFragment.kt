package com.serasa.fragmentviewmodel.genericsFragment.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.genericsFragment.adapter.AdapterGerenic
import com.serasa.fragmentviewmodel.genericsFragment.singleton.ListSingleton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GenericListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenericListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var showListGeneric: RecyclerView
    var parametroTipoList: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("key_list")?.let {
            parametroTipoList = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generic_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInformationListGeneric(view)
    }

    fun getInformationListGeneric(view: View) {

        var listOf = mutableListOf<Any>()

        if (parametroTipoList == TypeOfList.NOME.id) {
            listOf.addAll(ListSingleton.listOfNome)
        }else if (parametroTipoList == TypeOfList.CARRO.id){
            listOf.addAll(ListSingleton.listofCarro)
        }

        showListGeneric = view.findViewById(R.id.recyclerViewlistGeneric)
        showListGeneric.layoutManager = LinearLayoutManager(requireContext())
        showListGeneric.adapter = AdapterGerenic(listOf)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GenericListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(tipoGeneric : TypeOfList) =
            GenericListFragment().apply {
                arguments = Bundle().apply {
                    putInt("key_list", tipoGeneric.id)
                }
            }
    }
}

enum class TypeOfList(val id: Int) {
    NOME(1),
    CARRO(2)
}