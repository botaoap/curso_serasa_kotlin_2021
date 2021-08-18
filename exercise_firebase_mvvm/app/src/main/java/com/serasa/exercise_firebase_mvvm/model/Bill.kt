package com.serasa.exercise_firebase_mvvm.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot

data class Bill(
    val uid: String?,
    val name: String?,
    val price: Double?
) {
    companion object {
        fun fromData(snapshot: QueryDocumentSnapshot): Bill {
            return Bill(
                uid = snapshot.id,
                name = snapshot.data["name"] as? String,
                price = snapshot.data["price"] as? Double
            )
        }

        fun fromDocument(doc: DocumentReference): Bill {
            return Bill(
                uid = doc.id,
                name = null,
                price = null
            )
        }
    }
}