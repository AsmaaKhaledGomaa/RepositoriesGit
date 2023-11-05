package com.asoom.data.repo.repository

import com.asoom.data.database.GitHubRepoDatabase
import com.asoom.data.repo.repository.datasource.RepoLocalDataSourceIMP
import com.asoom.data.repo.repository.datasource.RepoRemoteDataSourceIMP
import com.asoom.data.remote.GitHubApi
import com.asoom.domain.datasource.RepoLocalDataSource
import com.asoom.domain.datasource.RepoRemoteDataSource
import com.asoom.domain.repo.repository.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepoRepository(remoteDataSource: RepoRemoteDataSourceIMP,
                              localDataSource: RepoLocalDataSourceIMP
    ): RepoRepository {
        return RepoRepositoryImp(remoteDataSource,localDataSource)
    }
    @Provides
    fun provideLocalDataSource(database: GitHubRepoDatabase): RepoLocalDataSource {
        return RepoLocalDataSourceIMP(database)
    }

    @Provides
    fun provideRemoteDataSource(api: GitHubApi): RepoRemoteDataSource {
        return RepoRemoteDataSourceIMP(api)
    }
}