package com.asoom.repository.di

import com.asoom.domain.repo.repository.RepoRepository
import com.asoom.domain.usecase.FetchRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideuseCaseModule( Repo: RepoRepository): FetchRepositoriesUseCase {
        return FetchRepositoriesUseCase(Repo)

    }
}