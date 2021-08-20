package com.serasa.exercise_firebase_mvvm.model

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot

data class Bill(
    val uid: String,
    var name: String,
    var price: Double
) {

    fun validarBill() : Boolean{

        if (price == null) {
            return false
        }

        if (price < 0) {
            return false
        }

        return true
    }

    companion object {
        fun fromData(snapshot: QueryDocumentSnapshot): Bill {
            return Bill(
                uid = snapshot.id,
                name = snapshot.data["name"] as String,
                price = snapshot.data["price"] as Double
            )
        }

        fun fromDocument(doc: DocumentSnapshot): Bill {
            return Bill(
                uid = doc.id,
                name = doc["name"] as String,
                price = doc["price"] as Double
            )
        }
    }
}