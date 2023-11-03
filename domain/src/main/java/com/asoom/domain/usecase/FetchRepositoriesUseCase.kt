package com.asoom.domain.usecase

import com.asoom.domain.repo.RepoRepository

class FetchRepositoriesUseCase (private val repoRepository: RepoRepository) {
    suspend operator fun invoke() = repoRepository.getRepositories()
}