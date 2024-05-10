package com.example.cachenetworkdb2024.worker

import android.content.Context
import androidx.core.app.ServiceCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.cachenetworkdb2024.database.DatabaseConnection
import com.example.cachenetworkdb2024.database.VideoRepository
import retrofit2.HttpException
import timber.log.Timber

class RefreshVideoWorker(appContext: Context, params: WorkerParameters): CoroutineWorker(appContext, params) {

    companion object {
        val WORK_NAME = "RefreshVideoWorker"
    }

    /**
     * A coroutine-friendly method to do your work.
     */
    override suspend fun doWork(): Result {
        val database = DatabaseConnection.getInstance(applicationContext)
        val repository = VideoRepository(database)
        Timber.i(":::: override suspend fun doWork()")

        return try {
            repository.refreshVideos()
            Result.retry()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}