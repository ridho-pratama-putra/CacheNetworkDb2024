package com.example.cachenetworkdb2024.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* by using @Entity, it will automatically recognized by DAO as a table name
*
*  */
@Entity
class VideoDatabaseModel (
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String
){
}

/**
 * Convert database results to domain objects
 * extension function must be located outside from
 */
fun List<VideoDatabaseModel>.asDomainModel(): List<VideoDomainModel> {
    return map {
        VideoDomainModel(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}