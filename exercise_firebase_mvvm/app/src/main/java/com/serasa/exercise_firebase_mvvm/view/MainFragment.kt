package com.serasa.exercise_firebase_mvvm.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.serasa.exercise_firebase_mvvm.R
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository
import com.serasa.exercise_firebase_mvvm.utils.replaceView
import com.serasa.exercise_firebase_mvvm.view_model.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var auth = AuthenticationRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<View>(R.id.imageViewArroBackToSignIn).setOnClickListener {
            auth.signOut()
            requireActivity().replaceView(SignInFragment.newInstance())
        }
    }

}