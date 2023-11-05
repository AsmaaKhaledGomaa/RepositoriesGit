package com.asoom.data.repo.details

import com.asoom.data.remote.GitHubApi
import com.asoom.domain.entity.RepoDetails
import com.asoom.domain.repo.Details.RepoDetailsRepositry
import javax.inject.Inject

class RepoDetailsRepositoryImp @Inject constructor(
    private val apiServices: GitHubApi
): RepoDetailsRepositry {

    override suspend fun getRepoDetails(owner: String, repo: String): RepoDetails {
        val result = apiServices.getRepoDetails(owner, repo)
        return result
    }

}
