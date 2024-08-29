package com.example.composeapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.views.users.NearbyUsersPage
import kotlinx.serialization.Serializable

@Composable
fun SetNavigationController(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth(),
        navController = navController,
        startDestination = Screen.NearbyUsersListPage.route
    ) {
        composable(Screen.NearbyUsersListPage.route) {
            NearbyUsersPage()
        }
    }
}

@Serializable
sealed class Screen(val route: String) {
    object NearbyUsersListPage : Screen("NearbyUsersListPage")
    object ProfilePage : Screen("ProfilePage")
}