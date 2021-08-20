package com.serasa.exercise_firebase_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.model.Bill
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository
import com.serasa.exercise_firebase_mvvm.repository.BillRepository

class MainViewModel : ViewModel() {

    private val _bill = MutableLiveData<List<Bill>>()
    var bill: LiveData<List<Bill>> = _bill

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val _isSignedIn = MutableLiveData<Boolean>(true)
    var isSignedIn: LiveData<Boolean> = _isSignedIn

    private val _user = MutableLiveData<FirebaseUser>()
    var user: LiveData<FirebaseUser> = _user

    private val billRepository = BillRepository()
    private val authRepository = AuthenticationRepository()

    fun fetchBill() {
        billRepository.fetchBills { bills, error ->
            if (error != null) {
                _error.value = error
            } else {
                _bill.value = bills
            }

        }
    }

    fun addBill(name: String, price: Double) {
        Bill(uid = "",name = name,price = price).apply {
            billRepository.addBill(this) {bill, error ->
                if (error != null) {
                    _error.value = error
                } else {
                    fetchBill()
                }
            }
        }
    }

    fun fetchCurrentUser() {
        authRepository.currentUser()?.apply {
            _user.value = this
        }
    }

    fun signOut() {
        authRepository.signOut()
        _isSignedIn.value = false
    }

}