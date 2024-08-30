package com.example.composeapp.utils

import android.graphics.Bitmap

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

object ImageUtils {


    @Composable
    fun showImageUrlCrop(modifier: Modifier = Modifier, url: String) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url).crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = "Image description",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }

    @Composable
    fun showImageUrl(modifier: Modifier = Modifier, url: String) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url).crossfade(true)
                .build(),
            contentDescription = "Image description",
            contentScale = ContentScale.Crop,
            modifier =  modifier
        )
    }


    @Composable
    fun loadImageBitmap(modifier: Modifier = Modifier, bmp: Bitmap) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(bmp).crossfade(true)
                .build(),
            contentDescription = "Image description",
            contentScale = ContentScale.Crop,
            modifier =  modifier
        )
    }

    @Composable
    fun showImageDrawable(
        modifier: Modifier = Modifier,
        drawable: Int,
        colorFilter: ColorFilter? = null
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier,
            colorFilter = colorFilter
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
ImageUtils.showImageUrl(url = "https://mega-onemega.com/wp-content/uploads/2024/01/MEGASTYLE-ELISIA-PARMISANO-IN-ART-1.jpg")
}