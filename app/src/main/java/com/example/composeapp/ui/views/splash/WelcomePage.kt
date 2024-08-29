package com.example.composeapp.ui.views.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.ui.views.base.BaseButton
import com.example.composeapp.utils.ImageUtils

@Composable
fun WelcomePage(onclick: () ->Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ImageUtils.showImageDrawable(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            drawable = R.drawable.ic_splash_backgorund_1,
            colorFilter = null
        )

        ImageUtils.showImageDrawable(
            modifier = Modifier
                .height(44.dp)
                .align(Alignment.Center),
            drawable = R.drawable.ic_logo_splash,
            colorFilter = ColorFilter.tint(Color(LocalContext.current.getColor(R.color.theme_color)))
        )

        BaseButton(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .align(Alignment.BottomStart)
            .padding(bottom = 16.dp, end = 36.dp, start = 36.dp),
            onclick = {onclick.invoke()},
            text = "Get Started",
            backgroundColor = Color(LocalContext.current.getColor(R.color.theme_color))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewx() {
    WelcomePage({})
}