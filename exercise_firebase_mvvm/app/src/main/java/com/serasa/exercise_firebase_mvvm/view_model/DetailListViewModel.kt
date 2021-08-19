package com.serasa.exercise_firebase_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.repository.BillRepository

class DetailListViewModel : ViewModel() {

    private val _bill = MutableLiveData<Bill>()
    var bill: LiveData<Bill> = _bill

    private val _uid = MutableLiveData<String>()
    var uid: LiveData<String> = _uid

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val _delete = MutableLiveData<Boolean>()
    var delete: LiveData<Boolean> = _delete

    private val _update = MutableLiveData<Boolean>()
    var update: LiveData<Boolean> = _update

    private val billRepository = BillRepository()

    fun fetchBillOndeId(uid: String) {
        billRepository.fetchOneBill(uid) { bills, error ->
            if (error != null) {
                _error.value = error
            } else {
                _bill.value = bills
            }
        }
    }

    fun fetchOneBill(uid: String) {
        billRepository.fetchOneBill(uid) { bills, error ->
            if (error != null) {
                _error.value = error
            } else {
                _bill.value = bills
            }
        }
    }

    fun deleteBill(uid: String) {
        billRepository.deleteBill(uid) { boolean ->
            if (boolean) {
                _delete.value = boolean
            }
        }
    }
    fun updateBill(bill: Bill) {
        billRepository.updateBill(bill) { bills, error ->
            if (error != null) {
                _error.value = error
            } else {
                _bill.value = bills
            }
        }
    }
}