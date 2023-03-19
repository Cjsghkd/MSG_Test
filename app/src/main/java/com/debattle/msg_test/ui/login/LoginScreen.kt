package com.debattle.msg_test.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    nevController: NavController
) {
    var login by remember { mutableStateOf("") }

    Row(modifier = Modifier.fillMaxWidth()) {
        BasicTextField(
            value = login,
            onValueChange = {
                login = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { nevController.navigate("home/$login") }) {
            Text(text = "로그인")
        }
    }
}






