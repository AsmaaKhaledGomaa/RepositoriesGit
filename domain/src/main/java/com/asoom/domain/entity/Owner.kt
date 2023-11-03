package com.asoom.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val login: String,
    val avatar_url: String
): Parcelable