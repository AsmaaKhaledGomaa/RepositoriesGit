package com.asoom.domain.datasource

import com.asoom.domain.entity.GitHubRepo

interface RepoLocalDataSource {
    suspend fun getLocalRepos(): List<GitHubRepo>
    suspend fun insertLocalRepos(repos: List<GitHubRepo>)
}
