package com.asoom.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asoom.domain.entity.GitHubRepo

@Dao
abstract class GitHubRepoDao {
    @Query("SELECT * FROM repositries")
    abstract suspend fun getAllRepos(): List<GitHubRepo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertRepos(repos: List<GitHubRepo>)
}
