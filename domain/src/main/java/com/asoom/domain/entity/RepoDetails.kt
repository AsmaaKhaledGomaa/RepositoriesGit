package com.asoom.domain.entity

import com.google.gson.annotations.SerializedName

data class RepoDetails(

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("owner")
    val owner: Owner? = null,
)