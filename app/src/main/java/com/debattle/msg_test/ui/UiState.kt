package com.debattle.msg_test.ui

import com.debattle.msg_test.network.model.GitHubModel

sealed interface UiState {
    object Loading: UiState
    data class Error(val message: String): UiState
    data class Success(val data: GitHubModel): UiState
}