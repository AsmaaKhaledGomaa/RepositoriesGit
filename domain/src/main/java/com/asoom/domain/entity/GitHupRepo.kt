package com.asoom.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHupRepo(
    val id: Long ,
    val name: String,
    val url: String,
    val login: String,
    val owner: Owner
): Parcelable
