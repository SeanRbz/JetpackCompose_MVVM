package com.example.composeapp.navigation

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.views.MainActivity
import com.example.composeapp.ui.views.login.LoginPage
import com.example.composeapp.ui.views.login.LoginSignupPage
import com.example.composeapp.ui.views.login.SignupPage
import com.example.composeapp.ui.views.splash.WelcomePage
import kotlinx.serialization.Serializable

@Composable
fun SetSplashNavController(paddingValues: PaddingValues) {
    var rememberNav by remember { mutableStateOf("") }
    val context = LocalContext.current

    val navController = rememberNavController()
    NavHost(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .fillMaxWidth(),
        navController = navController,
        startDestination = SplashScreens.WelcomePageScreen.route
    ) {
        composable(SplashScreens.WelcomePageScreen.route) {
            WelcomePage {
                rememberNav = SplashScreens.LoginSignupPageScreen.route
            }
        }
        composable(SplashScreens.LoginSignupPageScreen.route) {
            LoginSignupPage{
                rememberNav = it
            }
        }
        composable(SplashScreens.LoginPageScreen.route) {
            LoginPage{
                rememberNav = it
            }
        }
        composable(SplashScreens.SignupPageScreen.route) {
            SignupPage{
                rememberNav = it
            }
        }

        composable(SplashScreens.MainPageScreen.route) {
            MainActivity()
        }
    }

    when(rememberNav){
        SplashScreens.LoginSignupPageScreen.route -> {
            navController.navigate(rememberNav)
        }
        SplashScreens.LoginPageScreen.route -> {
            navController.navigate(rememberNav)
        }
        SplashScreens.SignupPageScreen.route -> {
            navController.navigate(rememberNav)
        }
        SplashScreens.MainPageScreen.route -> {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
        else->{}
    }
}

@Serializable
sealed class SplashScreens(val route: String) {
    object WelcomePageScreen : SplashScreens("WelcomePage")
    object LoginSignupPageScreen : SplashScreens("LoginSignupPage")
    object LoginPageScreen : SplashScreens("LoginPage")
    object SignupPageScreen : SplashScreens("SignupPage")
    object MainPageScreen : SplashScreens("MainPageScreen")
}