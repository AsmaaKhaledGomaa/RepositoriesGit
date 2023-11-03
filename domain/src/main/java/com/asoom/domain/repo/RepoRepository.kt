package com.asoom.domain.repo

import com.asoom.domain.entity.GitHupRepo
import com.asoom.domain.entity.RepoDetails

interface RepoRepository {
    suspend fun getRepositories(): List<GitHupRepo>

    suspend fun getRepoDetails(owner: String, repo: String): RepoDetails
}