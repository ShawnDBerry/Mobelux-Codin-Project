package com.example.mobeluxcodingproject.repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.mobeluxcodingproject.model.Album
import com.example.mobeluxcodingproject.network.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val albumService: AlbumService){

    suspend fun getAlbums(): Flow<Result<SnapshotStateList<Album>?>> {
        return createFlow()
    }

    private suspend fun createFlow(): Flow<Result<SnapshotStateList<Album>?>> {
        return flow {
            val result = albumService.getAlbums()
            if(result.isSuccessful){
                emit(Result.success(result.body()))
            }
        }.flowOn(Dispatchers.IO)
    }
}