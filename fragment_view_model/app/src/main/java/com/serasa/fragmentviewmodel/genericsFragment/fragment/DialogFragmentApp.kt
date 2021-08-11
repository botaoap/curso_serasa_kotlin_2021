package com.serasa.fragmentviewmodel.genericsFragment.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.serasa.fragmentviewmodel.R

class DialogFragmentApp : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Message Error")
            .setView(R.layout.dialog_sample)
            .setMessage(R.string.app_name)
            .setPositiveButton("Ok") {_,_->}
            .create()

}