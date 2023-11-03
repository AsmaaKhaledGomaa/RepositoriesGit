package com.asoom.data.remote

import com.asoom.domain.entity.GitHupRepo
import com.asoom.domain.entity.RepoDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("repositories")
    suspend fun getRepositories():List<GitHupRepo>

    @GET("repos/{owner}/{repo}")
    suspend fun getRepoDetails(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): RepoDetails

}
