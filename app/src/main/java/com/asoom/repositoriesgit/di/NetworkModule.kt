package com.asoom.repository.di

import com.asoom.data.remote.GitHubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.InstallIn
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20 , TimeUnit.SECONDS)
            .readTimeout(20 , TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }
}