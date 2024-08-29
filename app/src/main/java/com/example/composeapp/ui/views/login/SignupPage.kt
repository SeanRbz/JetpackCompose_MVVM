package com.example.composeapp.ui.views.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.navigation.SplashScreens
import com.example.composeapp.ui.views.base.BaseButton
import com.example.composeapp.ui.views.base.BaseInputField
import com.example.composeapp.utils.ImageUtils

@Composable
fun SignupPage(callback: (String) -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center)
                .padding(horizontal = 36.dp)
        ) {
            ImageUtils.showImageDrawable(
                modifier = Modifier
                    .height(44.dp)
                    .align(Alignment.CenterHorizontally),
                drawable = R.drawable.ic_logo_splash,
                colorFilter = ColorFilter.tint(Color(LocalContext.current.getColor(R.color.theme_color)))
            )

            Text(
                text = "Email",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                textAlign = TextAlign.Start
            )

            BaseInputField(
                modifier = Modifier.padding(top = 12.dp),
                label = "example@email.com",
                value = "",
                onValueChange = {})

            Text(
                text = "Password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                textAlign = TextAlign.Start
            )

            BaseInputField(
                modifier = Modifier.padding(top = 12.dp),
                label = "******",
                value = "",
                onValueChange = {})

            Text(
                text = "Confirm Password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                textAlign = TextAlign.Start
            )

            BaseInputField(
                modifier = Modifier.padding(top = 12.dp),
                label = "******",
                value = "",
                onValueChange = {})

            BaseButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp),
                onclick = {
                    callback.invoke(SplashScreens.MainPageScreen.route)
                },
                text = "Sign up".uppercase(),
                backgroundColor = Color(LocalContext.current.getColor(R.color.theme_color))
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Signin With",
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(.70f)
                    .padding(top = 36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ImageUtils.showImageDrawable(drawable = R.drawable.ic_facebook)
                ImageUtils.showImageDrawable(drawable = R.drawable.ic_google)
                ImageUtils.showImageDrawable(drawable = R.drawable.ic_apple)
            }
        }
    }
}