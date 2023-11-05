package com.asoom.data.repo.details

import com.asoom.data.remote.GitHubApi
import com.asoom.domain.repo.Details.RepoDetailsRepositry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DetailsModule {
    @Provides
    fun provideRepoDetailsRepository (api: GitHubApi): RepoDetailsRepositry {
        return RepoDetailsRepositoryImp(api)
    }
}