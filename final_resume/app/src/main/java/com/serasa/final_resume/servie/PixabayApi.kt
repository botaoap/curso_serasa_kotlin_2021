package com.serasa.final_resume.servie

import com.serasa.final_resume.BuildConfig
import com.serasa.final_resume.model.PixabayImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("/api/")
    suspend fun fetchImage(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") q: String,
        @Query("lang") lang: String = "en",
        @Query("image_type") imateType: String = "all",
        @Query("page") page: Int = 1

    ): Response<PixabayImage>

    @GET("/api/videos")
    suspend fun fetchVideo(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") q: String,
        @Query("lang") lang: String = "en",
//        @Query("video_type") imateType: String = "all",
        @Query("page") page: Int = 1

    ): Response<PixabayVideo>
}