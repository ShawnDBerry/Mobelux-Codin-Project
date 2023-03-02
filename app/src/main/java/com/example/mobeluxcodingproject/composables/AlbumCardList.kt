package com.example.mobeluxcodingproject.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.mobeluxcodingproject.model.Album

@Composable
fun AlbumCardList(albums: List<Album>) {
    LazyColumn {
        itemsIndexed(albums){_, album ->
            AlbumCard(album = album)
        }
    }
}