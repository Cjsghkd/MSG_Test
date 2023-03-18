package com.debattle.msg_test.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.msg_test.network.GitHubApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val gitHubApi: GitHubApi): ViewModel() {
    fun getUser(login: String?) {
        viewModelScope.launch {
            gitHubApi.getUser(login)
            Log.d("login", gitHubApi.getUser(login).toString())
        }
    }
}