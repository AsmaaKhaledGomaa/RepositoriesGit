package com.asoom.domain.entity

import com.google.gson.annotations.SerializedName

data class Owner(
    @field:SerializedName("login")
    val login: String? = null ,

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null
)