package com.example.mobeluxcodingproject.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mobeluxcodingproject.composables.AlbumCardList
import com.example.mobeluxcodingproject.theme.ComposeFetchRewardTheme
import com.example.mobeluxcodingproject.viewmodel.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumActivity : ComponentActivity() {
    private val viewModel: AlbumsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                setContent {
                    ComposeFetchRewardTheme(darkTheme = true) {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            viewModel.items?.let { AlbumCardList(albums = it) }
                        }
                    }
                }
            }
        }
    }
}