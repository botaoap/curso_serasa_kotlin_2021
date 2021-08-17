package com.serasa.firebase_with_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.serasa.firebase_with_mvvm.model.Bill
import com.serasa.firebase_with_mvvm.repository.BillRespository

class ContentViewModel : ViewModel() {

    private val _bill = MutableLiveData<List<Bill>>()
    var bill : LiveData<List<Bill>> = _bill

    private val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error

    private val billRepository = BillRespository()

    fun fetchBill() {
        billRepository.fetchBill { bills, error ->
            if (error != null) {
                _error.value = error
            }else {
                _bill.value = bills
            }

        }
    }


}