package com.serasa.firebase_with_mvvm.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.serasa.firebase_with_mvvm.model.Bill
import javax.security.auth.callback.Callback

class BillRespository {

    private val dataBase = Firebase.firestore

    fun fetchBill(callback: (List<Bill>?, String?) -> Unit)  {
        dataBase.collection("Bill")
            .get()
            .addOnSuccessListener { result ->

                val listOf = arrayListOf<Bill>()
                result.forEach {
                    val bill = Bill.fromData(it)
                    listOf.add(bill)
                }
                callback(listOf,null)

//                for (document in result) {
//                    println("${document.id} => ${document.data}")
//                }
            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }
}