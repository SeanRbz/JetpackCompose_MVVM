package com.example.composeapp.ui.views.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.navigation.SplashScreens
import com.example.composeapp.ui.views.base.BaseButton
import com.example.composeapp.ui.views.base.BaseCheckbox
import com.example.composeapp.ui.views.base.BaseInputField
import com.example.composeapp.ui.views.base.BaseNormalText
import com.example.composeapp.utils.ImageUtils

@Composable
fun LoginPage(callback: (String) -> Unit) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize().fillMaxWidth()
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

            BaseNormalText(
                text = "Email",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                textAlign = TextAlign.Start,
                textColor =  Color(context.getColor(R.color.light_dark))
            )

            BaseInputField(modifier = Modifier.padding(top = 12.dp),
                label = "example@email.com",
                value = "",
                onValueChange = {})
            BaseNormalText(
                text = "Password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                textAlign = TextAlign.Start,
                textColor =  Color(context.getColor(R.color.light_dark))
            )

            BaseInputField(modifier = Modifier.padding(top = 12.dp),
                label = "example@email.com",
                value = "",
                onValueChange = {})

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                BaseCheckbox({})
                BaseNormalText(
                    text = "Remember Me", textAlign = TextAlign.Start, textColor =  Color(context.getColor(R.color.light_dark))
                )

                Spacer(modifier = Modifier.weight(1f))

                VerticalDivider(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(vertical = 10.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                BaseNormalText(
                    text = "Forgot Password", textAlign = TextAlign.Start, textColor =  Color(context.getColor(R.color.light_dark))
                )

            }

                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 16.dp),
                    onclick = {
                        callback.invoke(SplashScreens.MainPageScreen.route)
                    },
                    text = "Sign In",
                    backgroundColor = Color(LocalContext.current.getColor(R.color.theme_color))
                )

                BaseNormalText(text = "Sign in With", textAlign = TextAlign.Start, textColor =  Color(context.getColor(R.color.light_dark)))

                //general modifier
                val modifier = Modifier.clickable {
                    callback.invoke(SplashScreens.MainPageScreen.route)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(.70f)
                        .padding(top = 36.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ImageUtils.showImageDrawable(
                        modifier = modifier, drawable = R.drawable.ic_facebook
                    )
                    ImageUtils.showImageDrawable(
                        modifier = modifier, drawable = R.drawable.ic_google
                    )
                    ImageUtils.showImageDrawable(
                        modifier = modifier, drawable = R.drawable.ic_apple
                    )
                }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginPage({})
}