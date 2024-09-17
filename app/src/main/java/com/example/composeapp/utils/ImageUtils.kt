package com.example.composeapp.utils

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.composeapp.R
import com.example.composeapp.ui.views.base.BaseNormalText

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


    @Composable
    fun showImageDrawableWithText(
        modifier: Modifier = Modifier,
        drawable: Int,
        text: String,
        colorFilter: ColorFilter? = null,
    ) {
        val context = LocalContext.current
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painterResource(id = drawable),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier,
                colorFilter = colorFilter
            )
            BaseNormalText(text = text, textColor = Color(context.getColor(R.color.light_gray_3)))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
ImageUtils.showImageUrl(url = "https://mega-onemega.com/wp-content/uploads/2024/01/MEGASTYLE-ELISIA-PARMISANO-IN-ART-1.jpg")
}