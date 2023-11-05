package com.asoom.domain.repo.Details

import com.asoom.domain.entity.RepoDetails

interface RepoDetailsRepositry {
    suspend fun getRepoDetails(owner: String, repo: String): RepoDetails

}