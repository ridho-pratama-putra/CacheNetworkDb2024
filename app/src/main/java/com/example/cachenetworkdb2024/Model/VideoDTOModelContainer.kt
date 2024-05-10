package com.example.cachenetworkdb2024.Model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoDTOModelContainer(val videos: List<VideoDTOModel>) {
}

fun VideoDTOModelContainer.asDomainModel(): List<VideoDomainModel> {
    return videos.map {
        VideoDomainModel(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}

fun VideoDTOModelContainer.asDatabaseModel(): Array<VideoDatabaseModel> {
    return videos.map {
        VideoDatabaseModel(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }.toTypedArray()
}
