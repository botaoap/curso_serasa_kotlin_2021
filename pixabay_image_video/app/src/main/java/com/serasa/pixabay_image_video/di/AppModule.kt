package com.serasa.pixabay_image_video.di

import com.serasa.pixabay_image_video.model.PixabayImage
import com.serasa.pixabay_image_video.service.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePixabayApi(retrofit: Retrofit): PixabayApi =
        retrofit.create(PixabayApi::class.java)
}