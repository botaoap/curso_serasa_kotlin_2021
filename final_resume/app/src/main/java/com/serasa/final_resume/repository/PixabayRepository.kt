package com.serasa.final_resume.repository

import com.serasa.final_resume.model.Image
import com.serasa.final_resume.servie.PixabayApi
import com.serasa.final_resume.servie.VideoConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PixabayRepository @Inject constructor(
    private var service: PixabayApi
) {

    suspend fun fetchImage(q: String, page: Int): List<Image>? {
        return withContext(Dispatchers.Default) {
            service.fetchImage(q = q, page = page).let { responseImage ->
                processData(responseImage)?.hits
            }
        }
    }

    suspend fun fetchVideo(q: String, page: Int): List<VideoConfig>? {
        return withContext(Dispatchers.Default) {
            service.fetchVideo(q = q, page = page)?.let { responseVideo ->
                processData(responseVideo)?.hits
            }
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}