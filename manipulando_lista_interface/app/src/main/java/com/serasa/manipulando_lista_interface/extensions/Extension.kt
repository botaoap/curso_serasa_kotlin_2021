package com.serasa.manipulando_lista_interface.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

// TODO: Criando uma extensio para usar em qualquer Activity
fun AppCompatActivity.showMessage(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}