package com.example.mobeluxcodingproject.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobeluxcodingproject.model.Album
import com.example.mobeluxcodingproject.theme.ComposeFetchRewardTheme

@Composable
fun AlbumCard(album: Album) {
    Card(
        modifier = Modifier.shadow(4.dp).padding(10.dp),
        shape = RoundedCornerShape(8.dp), elevation = 10.dp
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "User ID: " + album.userID, fontWeight = FontWeight.Bold)
                }
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "ID: " + album.id, fontWeight = FontWeight.Bold)
                }
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Title: " + album.title, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFetchRewardTheme {
        AlbumCard(album = Album(1, 1, "fasf"))
    }
}