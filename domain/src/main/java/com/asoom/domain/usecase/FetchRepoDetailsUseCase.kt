package com.asoom.domain.usecase

import com.asoom.domain.entity.RepoDetails
import com.asoom.domain.repo.RepoRepository
import javax.inject.Inject

class FetchRepoDetailsUseCase @Inject constructor(private val repository: RepoRepository) {
    suspend operator fun invoke(owner: String, repo: String): RepoDetails {
        return repository.getRepoDetails(owner, repo)
    }
}