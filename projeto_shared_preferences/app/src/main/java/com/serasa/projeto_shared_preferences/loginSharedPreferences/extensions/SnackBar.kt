package com.serasa.projeto_shared_preferences.loginSharedPreferences.extensions

import android.app.Activity
import android.hardware.input.InputManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.serasa.projeto_shared_preferences.R

fun AppCompatActivity.snackBar(view: View, @StringRes resId: Int) {
    hideKeyBoard()
    setupSnackBar(view, resId, R.color.red).apply {
        this.show()
    }
}

fun AppCompatActivity.hideKeyBoard() {
    val imm =
        window.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

private fun AppCompatActivity.setupSnackBar(
    v: View,
    @StringRes redId: Int,
    @ColorRes colorId: Int
) : Snackbar {
    return Snackbar.make(v, redId, Snackbar.LENGTH_LONG).apply {
        view.setBackgroundColor(getColor(colorId))
        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
    }


}