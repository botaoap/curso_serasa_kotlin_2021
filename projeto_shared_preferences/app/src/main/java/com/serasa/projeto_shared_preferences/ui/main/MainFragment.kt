package com.serasa.projeto_shared_preferences.ui.main

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit
import com.serasa.projeto_shared_preferences.R

class MainFragment : Fragment() {

    private lateinit var preferences : SharedPreferences

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferences = requireActivity().getSharedPreferences("preferences_session", Context.MODE_PRIVATE)
        val inputEmail = view.findViewById<EditText>(R.id.editTextInputEmail)

        val emailSalvo = preferences.getString("chave_email", "")
        if (!emailSalvo.isNullOrEmpty()) {
            inputEmail.setText(emailSalvo)
        }

        view.findViewById<Button>(R.id.buttonSave).apply {
            setOnClickListener {
                preferences.edit {
                    putString("chave_email", inputEmail.text.toString())
                    commit()
                }
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}