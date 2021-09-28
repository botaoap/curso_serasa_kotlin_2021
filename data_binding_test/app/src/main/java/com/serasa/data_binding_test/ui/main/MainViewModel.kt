package com.serasa.data_binding_test.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val _label = MutableLiveData<String>()
    val label: LiveData<String> = _label

    init {
        changeLabel()
    }

    fun changeLabel() {
        _label.value = (0..999).random().toString()
    }
}