package com.example.mobeluxcodingproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobeluxcodingproject.model.Album
import com.example.mobeluxcodingproject.repository.AlbumsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val albumsRepository: AlbumsRepository) : ViewModel(){
    private val errorMessage = mutableStateOf("")
    var items: List<Album>? by mutableStateOf(listOf())
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch(exceptionHandler) {
            albumsRepository.getAlbums().catch{ exception -> onError(exception.message.toString()) }
                .collect { response ->
                    if (response.isSuccess) {
//                        response.getOrNull()?.sortWith(compareBy({ it.listId }, { it.id }, { it.name }))
//                        response.getOrNull()?.removeAll { it.name == null || it.name == "" }
                        withContext(Dispatchers.Main) {
                            items = response.getOrNull()
                        }
                    }
                }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}