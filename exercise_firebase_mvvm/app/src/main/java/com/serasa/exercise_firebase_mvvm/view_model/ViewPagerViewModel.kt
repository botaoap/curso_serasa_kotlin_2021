package com.serasa.exercise_firebase_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.repository.BillRepository

class ViewPagerViewModel : ViewModel() {

    private val _bill = MutableLiveData<Bill>()
    var bill : LiveData<Bill> = _bill

    private val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error

    private val repository = BillRepository()

    fun fetchViewPager(uid: String) {
        repository.fetchOneBill(uid) { bill, error ->
            if (error != null){
                _error.value = error
            }else {
                _bill.value = bill
            }

        }
    }

}