package com.asoom.domain.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OwnerTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun ownerToJson(owner: Owner): String {
        return gson.toJson(owner)
    }

    @TypeConverter
    fun jsonToOwner(value: String): Owner {
        val type = object : TypeToken<Owner>() {}.type
        return gson.fromJson(value, type)
    }
}


