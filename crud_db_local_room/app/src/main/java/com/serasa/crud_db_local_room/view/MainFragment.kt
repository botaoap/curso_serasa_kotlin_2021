package com.serasa.crud_db_local_room.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serasa.crud_db_local_room.R
import com.serasa.crud_db_local_room.databinding.MainFragmentBinding
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository
import com.serasa.crud_db_local_room.utils.replaceView
import com.serasa.crud_db_local_room.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    private var auth = AuthenticantionRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainFragmentBinding.bind(view)

        binding.imageViewLogOutMain.setOnClickListener {
            auth.signOut()
            requireActivity().replaceView(SignInFragment.newInstance())
        }
    }


}