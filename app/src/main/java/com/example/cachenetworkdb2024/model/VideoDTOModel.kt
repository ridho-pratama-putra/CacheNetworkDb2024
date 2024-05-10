package com.example.cachenetworkdb2024.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoDTOModel(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?
) {

}