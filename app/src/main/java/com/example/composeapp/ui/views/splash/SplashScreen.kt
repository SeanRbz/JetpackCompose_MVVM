package com.example.composeapp.ui.views.splash

import android.content.Intent
import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.ui.views.MainActivity
import com.example.composeapp.utils.ImageUtils

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(LocalContext.current.getColor(R.color.theme_color)))
    ) {
        ImageUtils.showImageOnly(
            modifier = Modifier
                .height(44.dp)
                .align(Alignment.Center),
            drawable = R.drawable.ic_logo_splash
        )
    }
    val curr = LocalContext.current
    val handler = Handler()
    handler.postDelayed({
        curr.startActivity(Intent(curr, MainActivity::class.java))
    }, 3000)
}