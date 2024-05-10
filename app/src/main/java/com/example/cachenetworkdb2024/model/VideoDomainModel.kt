package com.example.cachenetworkdb2024.model

import android.net.Uri
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

    val launchUri: Uri
        get() {
            val httpUri = Uri.parse(url)
            return Uri.parse("vnd.youtube:" + httpUri.getQueryParameter("v"))
        }
}