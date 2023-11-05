package com.asoom.data.repo.repository.datasource

import com.asoom.data.remote.GitHubApi
import com.asoom.domain.datasource.RepoRemoteDataSource
import com.asoom.domain.entity.GitHubRepo
import javax.inject.Inject

class RepoRemoteDataSourceIMP @Inject constructor(private val api: GitHubApi) : RepoRemoteDataSource {
    override suspend fun getRemoteData(): List<GitHubRepo> {
        try {
            val result = api.getRepositories()
            return result

        }catch (ex :Exception){
            throw ex
        }
    }
}
