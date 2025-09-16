package com.example.ebook.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ebook.R

@Composable
fun BookPoster(title : String, author : String, imageUrl : String){
    AsyncImage(
        model = imageUrl,
        contentDescription = title,
        error = painterResource(R.drawable.ic_launcher_background),
        modifier = Modifier.size(80.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun BookPosterPreview(){
    BookPoster(
        title = "Milk & Honey",
        author = "Rupi Kaur",
        imageUrl = ""
    )
}