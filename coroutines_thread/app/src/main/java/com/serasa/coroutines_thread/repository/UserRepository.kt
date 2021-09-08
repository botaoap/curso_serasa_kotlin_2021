package com.serasa.coroutines_thread.repository

import com.serasa.coroutines_thread.model.User
import com.serasa.coroutines_thread.service.Endpoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val endpoint: Endpoint
){
    fun getUsers(): Deferred<List<User>?> {
        return CoroutineScope(Dispatchers.Main).async {
            endpoint.getUsers().let {
                processData(it)
            }
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}
