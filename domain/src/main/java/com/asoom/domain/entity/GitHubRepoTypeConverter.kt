package com.asoom.domain.entity

import androidx.room.TypeConverter
import com.google.gson.Gson

class GitHubRepoTypeConverter {

    private val gson = Gson()
        @TypeConverter
        fun fromGitHubRepo(repo: GitHubRepo?): String? {
            return gson.toJson(repo)
        }

        @TypeConverter
        fun toGitHubRepo(json: String?): GitHubRepo? {
            return if (json == null) null else gson.fromJson(json, GitHubRepo::class.java)
        }
}



