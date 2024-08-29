package com.example.composeapp.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.RequestBuilderTransform
import com.bumptech.glide.request.RequestOptions
import com.example.composeapp.R


object ImageUtils {

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
   fun showImageUrlCrop(modifier: Modifier,url: String){
        GlideImage(model = url, contentDescription = "imageContent",
            modifier = modifier,contentScale = ContentScale.Crop )
   }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun showImageUrl(modifier: Modifier,url: String){
        GlideImage(model = url, contentDescription = "imageContent",
            modifier = modifier,contentScale = ContentScale.Crop)
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun loadImageBitmap(modifier: Modifier,bmp: Bitmap){
        GlideImage(model = bmp, contentDescription = "imageContent",
            modifier = modifier)
    }

    @Composable
    fun showImageOnly(modifier: Modifier,drawable: Int){
        Image(
            painterResource(drawable),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}