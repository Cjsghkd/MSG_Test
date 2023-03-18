package com.debattle.msg_test.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debattle.msg_test.network.model.GitHubModel
import com.debattle.msg_test.viewmodel.LoginViewModel

@Composable
fun Screen(
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    var id by remember { mutableStateOf("") }

    Row(modifier = Modifier.fillMaxWidth()) {
        BasicTextField(
            value = id,
            onValueChange = {
                id = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { loginViewModel.getUser(id) }) {
            Text(text = "로그인")
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))

    }
}

@Composable
fun getName(gitHubData: GitHubModel) {
    Text(text = gitHubData.name.toString())
}

@Composable
fun getId(gitHubData: GitHubModel) {
    Text(text = gitHubData.id.toString())
}

@Composable
fun getProfile(gitHubData: GitHubModel) {
    Text(text = gitHubData.avatarUrl.toString())
}

@Composable
fun getBio(gitHubData: GitHubModel) {
    Text(text = gitHubData.bio.toString())
}

@Composable
fun getFollowers(gitHubData: GitHubModel) {
    Text(text = gitHubData.followers.toString())
}

@Composable
fun getFollowing(gitHubData: GitHubModel) {
    Text(text = gitHubData.following.toString())
}




