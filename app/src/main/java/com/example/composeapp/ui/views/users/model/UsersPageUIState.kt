package com.example.composeapp.ui.views.users.model

import com.example.composeapp.repository.entities.UsersData


data class UsersPageUIState (
    val usersList: List<UsersData> = listOf(),
    val selectedUser: UsersData? = null,
    val isLoading: Boolean = false
)