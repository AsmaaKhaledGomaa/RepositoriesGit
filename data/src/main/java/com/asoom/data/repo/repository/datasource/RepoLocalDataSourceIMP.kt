package com.asoom.data.repo.repository.datasource

import com.asoom.data.database.GitHubRepoDatabase
import com.asoom.domain.datasource.RepoLocalDataSource
import com.asoom.domain.entity.GitHubRepo
import javax.inject.Inject

class RepoLocalDataSourceIMP @Inject constructor(
    private val gitHubRepoDatabase: GitHubRepoDatabase
): RepoLocalDataSource {
    override suspend fun getLocalRepos(): List<GitHubRepo> {
        return gitHubRepoDatabase.githubRepoDao().getAllRepos()
    }

    override suspend fun insertLocalRepos(repos: List<GitHubRepo>) {
        gitHubRepoDatabase.githubRepoDao().insertRepos(repos)
    }

}