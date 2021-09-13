package com.serasa.pixabay_image_video.service

import com.serasa.pixabay_image_video.BuildConfig
import com.serasa.pixabay_image_video.model.PixabayImage
import com.serasa.pixabay_image_video.model.PixabayVideo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun fetchImage(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") q: String,
        @Query("lang") lang: String = "pt",
        @Query("image_type") imateType: String = "all",
        @Query("page") page: Int = 1

        ): Response<PixabayImage>

    @GET("/api/videos")
    suspend fun fetchVideos(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") q: String,
        @Query("lang") lang: String = "en",
//        @Query("video_type") imateType: String = "all",
        @Query("page") page: Int = 1

    ): Response<PixabayVideo>
}