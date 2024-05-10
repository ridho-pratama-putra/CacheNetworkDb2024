package com.example.cachenetworkdb2024.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cachenetworkdb2024.model.VideoDomainModel
import com.example.cachenetworkdb2024.model.asDatabaseModel
import com.example.cachenetworkdb2024.model.asDomainModel
import com.example.cachenetworkdb2024.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository(private val database: DatabaseConnection) {

    /**
     * A playlist of videos that can be shown on the screen.
     */
    val videos: LiveData<List<VideoDomainModel>> = database.videoDatabaseDao.getVideos().map { it -> it.asDomainModel() }

    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * To actually load the videos for use, observe [videos]
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = Network.devbytes.getPlaylist()
            database.videoDatabaseDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}