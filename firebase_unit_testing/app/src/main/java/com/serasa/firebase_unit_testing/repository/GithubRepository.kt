package com.serasa.firebase_unit_testing.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.serasa.firebase_unit_testing.model.GitUserModel
import com.serasa.firebase_unit_testing.repository.interfaces.IGithubUsersResult
import com.serasa.firebase_unit_testing.service.GithubAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubRepository(
    private val api: GithubAPI,
    private val observer: IGithubUsersResult,
    private val firebaseDb : FirebaseFirestore
) {
    companion object {
        const val COLLECTION_NAME = "github_users"
    }


    suspend fun fetchUsers() {
        val response = withContext(Dispatchers.Default) {
            api.fetchUsers()
        }
        if (response.isSuccessful) observer.successApi() else observer.failureApi()
    }

    fun saveUserOnFirebase(user: GitUserModel) {
        val task = firebaseDb.collection(COLLECTION_NAME).add(user)
        if (task.isSuccessful) observer.successFirebase() else observer.failureApi()
    }

}