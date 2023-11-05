package com.asoom.domain.repo.repository

import com.asoom.domain.entity.GitHubRepo

interface RepoRepository {
    suspend fun getRepositoriesFromRemote(): List<GitHubRepo>
    suspend fun getRepositoriesFromLocal(): List<GitHubRepo>

}
