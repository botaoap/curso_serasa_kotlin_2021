package com.serasa.pixabay_image_video.repository

import com.serasa.pixabay_image_video.model.Image
import com.serasa.pixabay_image_video.service.PixabayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PixabayImageRepository @Inject constructor(
    private val service: PixabayApi
){
    suspend fun fetchImage(q: String, page: Int): List<Image>? {
        return withContext(Dispatchers.Default) {
            service.fetchImage(q = q, page = page).let { resposneImage ->
                processData(resposneImage)?.hits
            }
        }
    }


    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}