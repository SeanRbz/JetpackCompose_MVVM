package com.example.composeapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.repository.usecases.LoginUserUseCase
import com.example.composeapp.repository.usecases.LoginUserUseCaseParams
import com.example.composeapp.repository.usecases.SignupUserUseCase
import com.example.composeapp.repository.usecases.SignupUserUseCaseParams
import com.example.composeapp.ui.views.login.LoginSignupUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginSignupViewModel @Inject constructor(
    val loginUseCase: LoginUserUseCase,
    val signupUseCase: SignupUserUseCase
) : ViewModel() {
    private var _uiState: MutableStateFlow<LoginSignupUIState> =
        MutableStateFlow(LoginSignupUIState())
    val uiState: StateFlow<LoginSignupUIState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val params = LoginUserUseCaseParams(email = email , password = password)
            loginUseCase(params).collectLatest { result->

            }
        }

    }

    fun signup(email: String, password: String) {
        viewModelScope.launch {
            val params = SignupUserUseCaseParams(email = email , password = password)
            signupUseCase(params).collectLatest { result->

            }
        }
    }

    fun setEmail(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }

    fun setPassword(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }
}