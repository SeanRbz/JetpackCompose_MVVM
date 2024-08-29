package com.example.composeapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.repository.entities.UserDataResponse
import com.example.composeapp.repository.entities.UsersData
import com.example.composeapp.repository.usecases.GetNearbyUsersUseCase
import com.example.composeapp.ui.views.users.model.UsersPageUIState
import com.example.composeapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(val getNearbyUsersUseCase: GetNearbyUsersUseCase) :
    ViewModel() {
    private var _uiState: MutableStateFlow<UsersPageUIState> = MutableStateFlow(UsersPageUIState())
    val uiState: StateFlow<UsersPageUIState> = _uiState.asStateFlow()

    fun setSelectedUser(user: UsersData) {
        _uiState.update { it.copy(selectedUser = user) }
    }

    fun getNearbyUsers() {
        viewModelScope.launch {
            getNearbyUsersUseCase(Unit).collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        val list = result.data.list
                        val firstUser: UsersData? = if (result.data.list.size > 1) {
                            list.get(0)
                        } else {
                            null
                        }
                        _uiState.update {
                            it.copy(isLoading = false, usersList = list, selectedUser = firstUser)
                        }
                    }

                    is Result.Error -> {
                        _uiState.update {
                            it.copy(isLoading = false)
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}