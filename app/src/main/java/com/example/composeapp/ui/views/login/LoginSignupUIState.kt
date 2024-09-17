package com.example.composeapp.ui.views.login

data class LoginSignupUIState(
    val email: String = "",
    val password: String = "",
    val userId: String = "",
    val isLoading: Boolean = false
)