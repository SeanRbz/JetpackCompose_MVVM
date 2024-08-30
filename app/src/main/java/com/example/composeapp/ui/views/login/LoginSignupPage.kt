package com.example.composeapp.ui.views.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.navigation.SplashScreens
import com.example.composeapp.ui.views.base.BaseButton
import com.example.composeapp.utils.ImageUtils

@Composable
fun LoginSignupPage(callback: (String) -> Unit) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        ImageUtils.showImageDrawable(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            drawable = R.drawable.ic_splash_background_2,
            colorFilter = null
        )

        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            BaseButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp, end = 36.dp, start = 36.dp),
                onclick = {
                    callback.invoke(SplashScreens.LoginPageScreen.route)
                },
                text = "Sign in",
                backgroundColor = Color(context.getColor(R.color.theme_color))
            )

            BaseButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp, end = 36.dp, start = 36.dp)
                    .border(
                        BorderStroke(
                            2.dp,
                            Color(context.getColor(R.color.theme_color))
                        ), RoundedCornerShape(12)
                    ),
                onclick = {
                    callback.invoke(SplashScreens.SignupPageScreen.route)
                },
                text = "Sign up",
                backgroundColor = Color.Transparent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginSignupPagePreview() {
    LoginSignupPage({})
}