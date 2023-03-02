package com.example.mobeluxcodingproject.network

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.mobeluxcodingproject.model.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<SnapshotStateList<Album>>
}