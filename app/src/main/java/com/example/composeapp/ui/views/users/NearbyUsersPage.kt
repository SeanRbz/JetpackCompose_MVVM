package com.example.composeapp.ui.views.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.R
import com.example.composeapp.ui.viewModel.UsersViewModel
import com.example.composeapp.ui.views.MainActivityView
import com.example.composeapp.ui.views.base.BaseNormalText
import com.example.composeapp.ui.views.users.model.UsersPageUIState

@Composable
fun NearbyUsersPage(viewModel: UsersViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(uiState.usersList) { user ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ShowUserImageCircle(user = user, callback = {
                        viewModel.setSelectedUser(it)
                    })
                    BaseNormalText(text = user.name?:"", textAlign = TextAlign.Center, textColor =
                    Color(context.getColor(R.color.light_dark)))
                }
            }
        }
        if (uiState.selectedUser != null) {
            ShowProfileBanner(
                url = uiState.selectedUser?.imageUrl ?: "", name = uiState.selectedUser?.name ?: "",
                description = uiState.selectedUser?.description ?: "",
                location = uiState.selectedUser?.location ?: "",
            )
        }
    }
}

