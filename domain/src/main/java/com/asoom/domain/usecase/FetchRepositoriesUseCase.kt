package com.asoom.domain.usecase

import com.asoom.domain.entity.GitHubRepo
import com.asoom.domain.repo.repository.RepoRepository
import javax.inject.Inject

class FetchRepositoriesUseCase @Inject constructor(
    private val repoRepository: RepoRepository
) {
    suspend fun fetchRepositories(): List<GitHubRepo> {
        // Attempt to fetch data from the remote source
        val remoteData = try {
            repoRepository.getRepositoriesFromRemote()
        } catch (e: Exception) {
            // Handle errors and fall back to the local source in case of network issues
            repoRepository.getRepositoriesFromLocal()
        }

        // If data is available from the remote source, return it
        if (remoteData.isNotEmpty()) {
            return remoteData
        }

        // If no data is available from the remote source, return the data from the local source
        return repoRepository.getRepositoriesFromLocal()
    }
}
