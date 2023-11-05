package com.asoom.data.repo.repository

import android.util.Log
import com.asoom.domain.datasource.RepoLocalDataSource
import com.asoom.domain.datasource.RepoRemoteDataSource
import com.asoom.domain.entity.GitHubRepo
import com.asoom.domain.repo.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImp @Inject constructor(
    private val remoteDataSource: RepoRemoteDataSource,
    private val localDataSource: RepoLocalDataSource
) : RepoRepository {
    override suspend fun getRepositoriesFromRemote(): List<GitHubRepo> {
        try {
            // Fetch data from the remote data source
            val data = remoteDataSource.getRemoteData()
            Log.d("Print", "repo imp remote: $data")
            // Save the data to the local data source for caching
            localDataSource.insertLocalRepos(data)
            return data
        }catch (ex :Exception){
            val data = localDataSource.getLocalRepos()
            Log.d("Print", "repo imp local : $data")

            return data

        }
    }
    override suspend fun getRepositoriesFromLocal(): List<GitHubRepo> {
        // Fetch data from the local data source
        val data = localDataSource.getLocalRepos()
        Log.d("Print", "repo imp local: $data")

        return data

    }

}
