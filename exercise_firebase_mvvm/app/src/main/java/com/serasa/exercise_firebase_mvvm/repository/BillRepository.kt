package com.serasa.exercise_firebase_mvvm.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.serasa.exercise_firebase_mvvm.model.Bill

const val BILL_COLLECTION = "Bill"

class BillRepository {

    private val dataBase = Firebase.firestore

    fun fetchBills(callback: (List<Bill>?, String?) -> Unit) {
        dataBase.collection(BILL_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                val lisOf = arrayListOf<Bill>()
                result.forEach {
                    val bill = Bill.fromData(it)
                    lisOf.add(bill)
                }
                callback(lisOf, null)
            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }

    fun addBill(bill: Bill, callback: (Bill?, String?) -> Unit) {
        dataBase.collection(BILL_COLLECTION)
            .add(bill)
            .addOnSuccessListener {
                Bill.fromDocument(it).apply {
                    callback(this,null)
                }
            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)

            }
    }

    fun removeBill(uid: String, callback: (Boolean) -> Unit) {
        dataBase.collection(BILL_COLLECTION)
            .document(uid)
            .delete()
            .addOnSuccessListener {
                callback(true)
            }
            .addOnFailureListener {
                callback(false)
            }
    }
}