package com.example.composeapp.constants

import com.example.composeapp.R
import com.example.composeapp.navigation.BottomNavigationItems
import com.example.composeapp.navigation.MainActivityScreens


object Constants {

    val NavBottomList = listOf(
        BottomNavigationItems(
            title = "Home",
            badgeCount = 0,
            icon = R.drawable.ic_home,
            nav = MainActivityScreens.NearbyUsersListPage
        ),
        BottomNavigationItems(
            title = "Message",
            badgeCount = 0,
            icon = R.drawable.ic_message,
            nav = MainActivityScreens.MessagesPage
        ),
        BottomNavigationItems(
            title = "Profile",
            badgeCount = 0,
            icon = R.drawable.ic_profile,
            nav = MainActivityScreens.ProfilePage
        ),
        BottomNavigationItems(
            title = "Notification",
            badgeCount = 0,
            icon = R.drawable.ic_notification,
            nav = MainActivityScreens.NotificationPage
        )
    )
}