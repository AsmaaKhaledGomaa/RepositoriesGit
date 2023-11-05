package com.asoom.domain.datasource

import com.asoom.domain.entity.GitHubRepo

interface RepoRemoteDataSource {
    suspend fun getRemoteData(): List<GitHubRepo>
}