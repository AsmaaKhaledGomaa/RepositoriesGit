package com.asoom.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.asoom.domain.entity.GitHubRepo
import com.asoom.domain.entity.GitHubRepoTypeConverter
import com.asoom.domain.entity.OwnerTypeConverter


@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
@TypeConverters(OwnerTypeConverter::class, GitHubRepoTypeConverter::class)
abstract class GitHubRepoDatabase : RoomDatabase() {
    abstract fun githubRepoDao(): GitHubRepoDao

}
