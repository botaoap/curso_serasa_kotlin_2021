package com.serasa.fragmentviewmodel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.fragmentviewmodel.R
import com.serasa.fragmentviewmodel.adapter.AdapterToFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var showListWhatever: RecyclerView
    private lateinit var adapter: AdapterToFragment
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInformationList(view)
    }

    fun getInformationList(view: View) {
        adapter = AdapterToFragment()

        showListWhatever = view.findViewById(R.id.recyclerViewListWhatEver)
        showListWhatever.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        showListWhatever.adapter = adapter
    }

}