package com.example.mobeluxcodingproject.network

import com.example.mobeluxcodingproject.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlbumRetrofitInstance {

    @Provides
    @Singleton
    fun retrofitInstance(): AlbumService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumService::class.java)
    }
}