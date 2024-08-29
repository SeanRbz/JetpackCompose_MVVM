package com.example.composeapp.ui.views.users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.viewModel.UsersViewModel
import com.example.composeapp.ui.views.users.model.UsersPageUIState


@Composable
fun NearbyUsersPage(viewModel: UsersViewModel = hiltViewModel()) {
    val uiState: UsersPageUIState by viewModel.uiState.collectAsState()

    viewModel.getNearbyUsers()

    Column {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(uiState.usersList) { user ->
                ShowUserImageCircle(user = user, callback = {
                   viewModel.setSelectedUser(it)
                })
            }
        }

        if(uiState.selectedUser!=null){
            ShowProfileBanner(
                url = uiState.selectedUser?.imageUrl ?: "", name = uiState.selectedUser?.name ?: "",
                description = uiState.selectedUser?.description ?: "",
                location = uiState.selectedUser?.location ?: "",
            )
        }
    }

}

