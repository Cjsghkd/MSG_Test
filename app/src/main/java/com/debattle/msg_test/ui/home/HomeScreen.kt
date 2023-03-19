package com.debattle.msg_test.ui.home

import android.util.Log
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
        Text(text = homeViewModel.getUser().toString())
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
                Column(modifier = Modifier.fillMaxSize()) {
                    Log.d("user", (uiState as UiState.Success).data.toString())
                    getData(gitHubData = (uiState as UiState.Success).data)
                }
            }
        }
    }
}

@Composable
fun getData(gitHubData: GitHubModel) {
    Text(text = gitHubData.name.toString())
    Text(text = gitHubData.login.toString())
    Text(text = gitHubData.id.toString())
    Image(painter = rememberImagePainter(data = gitHubData.avatarUrl), contentDescription = null)
    Text(text = gitHubData.bio.toString())
    Text(text = gitHubData.followers.toString())
    Text(text = gitHubData.following.toString())
}