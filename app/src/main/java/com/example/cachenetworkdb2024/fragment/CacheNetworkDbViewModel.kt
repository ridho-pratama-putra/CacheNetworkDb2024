package com.example.cachenetworkdb2024.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cachenetworkdb2024.database.DatabaseConnection
import com.example.cachenetworkdb2024.database.VideoRepository
import kotlinx.coroutines.launch

class CacheNetworkDbViewModel(application: Application) : AndroidViewModel(application) {

    private val database = DatabaseConnection.getInstance(application)
    private val videosRepository = VideoRepository(database)

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        viewModelScope.launch {
            videosRepository.refreshVideos()
        }
    }

    val playlist = videosRepository.videos

    /**
     * Factory for constructing DevByteViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CacheNetworkDbViewModel::class.java)) {
                return CacheNetworkDbViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}