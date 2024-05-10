package com.example.cachenetworkdb2024.Model

import com.example.cachenetworkdb2024.util.smartTruncate

data class VideoDomainModel(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String
) {

    val shortDescription: String
        get() {
            return description.smartTruncate(200)
        }
}