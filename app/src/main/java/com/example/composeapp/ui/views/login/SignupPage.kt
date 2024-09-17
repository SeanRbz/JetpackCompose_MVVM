package com.example.composeapp.ui.views.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.navigation.SplashScreens
import com.example.composeapp.ui.viewModel.LoginSignupViewModel
import com.example.composeapp.ui.views.base.BaseButton
import com.example.composeapp.ui.views.base.BaseInputField
import com.example.composeapp.ui.views.base.BaseNormalText
import com.example.composeapp.utils.ImageUtils

@Composable
fun SignupPage(viewModel: LoginSignupViewModel, callback: (String) -> Unit){
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

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

            BaseNormalText( text = "Email", modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp),
                textColor =  Color(context.getColor(R.color.light_dark)))

            BaseInputField(
                modifier = Modifier.padding(top = 12.dp),
                label = if (uiState.email != "") "example@email.com" else "",
                value = "",
                onValueChange = {})

            BaseNormalText( text = "Password", modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp))

            BaseInputField(
                modifier = Modifier.padding(top = 12.dp),
                label = if (uiState.email != "") "******" else "",
                value = "",
                onValueChange = {})
            BaseNormalText( text = "Confirm Password", modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp),
                textColor =  Color(context.getColor(R.color.light_dark)))

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

            BaseNormalText( text = "Sign in With", modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp),
                textColor =  Color(context.getColor(R.color.light_dark)))

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