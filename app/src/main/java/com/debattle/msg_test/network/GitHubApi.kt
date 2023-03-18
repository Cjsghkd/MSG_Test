package com.debattle.msg_test.network

import com.debattle.msg_test.network.model.GitHubModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users/{login}")
    suspend fun getUser(@Path("login") login: String?): GitHubModel
}
