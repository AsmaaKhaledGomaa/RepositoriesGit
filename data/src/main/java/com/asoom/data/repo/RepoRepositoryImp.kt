package com.asoom.data.repo

import com.asoom.data.remote.GitHubApi
import com.asoom.domain.entity.GitHupRepo
import com.asoom.domain.entity.RepoDetails
import com.asoom.domain.repo.RepoRepository

class RepoRepositoryImp(private val apiServices: GitHubApi): RepoRepository {
    override suspend fun getRepositories(): List<GitHupRepo> = apiServices.getRepositories()

    override suspend fun getRepoDetails(owner: String, repo: String): RepoDetails
            = apiServices.getRepoDetails(owner, repo)
}
