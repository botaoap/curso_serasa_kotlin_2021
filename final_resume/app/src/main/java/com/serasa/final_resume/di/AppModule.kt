package com.serasa.final_resume.di

import android.content.Context
import com.serasa.final_resume.databse.AppDatabase
import com.serasa.final_resume.databse.dao.PixabayDAO
import com.serasa.final_resume.servie.NotificationHandler
import com.serasa.final_resume.servie.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    fun providePixabayDao(@ApplicationContext context: Context): PixabayDAO =
        AppDatabase.getDatabase(context).getPixabayDao()

    @Provides
    fun provideNotificationHandler(@ApplicationContext context: Context): NotificationHandler =
        NotificationHandler(context)
}