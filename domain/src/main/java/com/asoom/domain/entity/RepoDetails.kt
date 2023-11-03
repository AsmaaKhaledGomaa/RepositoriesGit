package com.asoom.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepoDetails(
    val id: Long,
    val name: String,
    val owner: Owner,
    val description: String,
    val languages_url: String,
    val created_at: String
): Parcelable