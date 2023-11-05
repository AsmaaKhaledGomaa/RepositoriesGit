package com.asoom.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositries")
data class GitHubRepo(

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    @ColumnInfo
    val id: Long = 0 ,

    @field:SerializedName("name")
    @ColumnInfo
    val name: String? = null ,

    @field:SerializedName("login")
    @ColumnInfo
    val login: String? = null ,

    @field:SerializedName("owner")
    @ColumnInfo
    val owner: Owner
)