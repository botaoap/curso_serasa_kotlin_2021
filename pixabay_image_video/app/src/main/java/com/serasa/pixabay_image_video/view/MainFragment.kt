package com.serasa.pixabay_image_video.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.serasa.pixabay_image_video.R

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}