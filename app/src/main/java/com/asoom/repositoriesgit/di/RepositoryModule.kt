package com.asoom.repository.di

import com.asoom.data.remote.GitHubApi
import com.asoom.data.repo.RepoRepositoryImp
import com.asoom.domain.repo.RepoRepository
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
    fun provideRepoRepository(gitHubApi: GitHubApi): RepoRepository {
        return RepoRepositoryImp(gitHubApi)
    }
}