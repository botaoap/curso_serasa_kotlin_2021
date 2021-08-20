package com.serasa.exercise_firebase_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.view_model.ViewPagerViewModel

class ViewPagerFragment : Fragment(R.layout.view_pager_fragment) {

    companion object {
        fun newInstance() = ViewPagerFragment()
    }

    private lateinit var viewViewModel: ViewPagerViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }

}