package com.debattle.msg_test.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.msg_test.network.GitHubApi
import com.debattle.msg_test.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gitHubApi: GitHubApi,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val login: String = checkNotNull(savedStateHandle["login"])
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Success(gitHubApi.getUser(login))
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "알 수 없는 에러")
            }
        }
    }
}