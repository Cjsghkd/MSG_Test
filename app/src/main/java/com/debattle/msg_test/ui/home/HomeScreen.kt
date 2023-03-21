package com.debattle.msg_test.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.debattle.msg_test.network.model.GitHubModel
import com.debattle.msg_test.ui.UiState
import com.debattle.msg_test.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when(uiState) {
            is UiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = (uiState as UiState.Error).message)
                }
            }
            UiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
            is UiState.Success -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    getData(gitHubData = (uiState as UiState.Success).data)
                }
            }
        }
    }
}

@Composable
fun getData(gitHubData: GitHubModel) {
    Text(text = "이름 : " + gitHubData.name.toString())
    Text(text = "닉네임 : " + gitHubData.login.toString())
    Text(text = "아이디 : " + gitHubData.id.toString())
    Image(painter = rememberAsyncImagePainter(model = gitHubData.avatarUrl), contentDescription = null)
    Text(text = "한줄 소개 : " + gitHubData.bio.toString())
    Text(text = "팔로워 수 : " + gitHubData.followers.toString())
    Text(text = "팔로잉 수 : " + gitHubData.following.toString())
}