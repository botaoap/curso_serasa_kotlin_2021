package com.serasa.dependency_injection_users_github.repository

import com.serasa.dependency_injection_users_github.model.User
import com.serasa.dependency_injection_users_github.service.EndpointUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val endpoint: EndpointUser
){

    fun fetchUsers(callback: (List<User>?, String?) -> Unit) {
        endpoint.fetchUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.body() != null) {
                    callback(response.body(), null)
                } else {
                    callback(null, "Erroe inject")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                callback(null, t.message)
            }
        })

    }

}