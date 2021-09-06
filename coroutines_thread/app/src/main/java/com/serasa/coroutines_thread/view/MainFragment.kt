package com.serasa.coroutines_thread.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.serasa.coroutines_thread.R
import com.serasa.coroutines_thread.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}