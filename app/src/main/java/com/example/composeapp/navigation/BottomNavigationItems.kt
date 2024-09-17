package com.example.composeapp.navigation

data class BottomNavigationItems(
    val title: String,
    val badgeCount: Int,
    val icon: Int,
    val nav: MainActivityScreens
)