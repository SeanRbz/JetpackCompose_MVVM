package com.example.composeapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeapp.ui.viewModel.UsersViewModel
import com.example.composeapp.ui.views.nearbyUsers.NearbyUsersPage
import kotlinx.serialization.Serializable

@Composable
fun SetNavigationController(innerPadding: PaddingValues, navController: NavHostController) {
    val viewModel: UsersViewModel = hiltViewModel()
    viewModel.getNearbyUsers()
    NavHost(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth(),
        navController = navController,
        startDestination = MainActivityScreens.NearbyUsersListPage.route
    ) {
        composable(MainActivityScreens.NearbyUsersListPage.route) {
            NearbyUsersPage(viewModel)
        }
    }
}

@Serializable
sealed class MainActivityScreens(val route: String) {
    object NearbyUsersListPage : MainActivityScreens("NearbyUsersListPage")
    object ProfilePage : MainActivityScreens("ProfilePage")
    object MessagesPage : MainActivityScreens("MessagesPage")
    object NotificationPage : MainActivityScreens("NotificationPage")
}