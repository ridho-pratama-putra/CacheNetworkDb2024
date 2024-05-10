package com.example.cachenetworkdb2024.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cachenetworkdb2024.model.VideoDatabaseModel

@Database(entities = [VideoDatabaseModel::class], version = 1, exportSchema = true)
abstract class DatabaseConnection: RoomDatabase() {
    abstract val videoDatabaseDao: VideoDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: DatabaseConnection? = null // keep reference once we have one. prevent us repeatedly opening database yang expensive

        fun getInstance(context: Context) : DatabaseConnection {

            // ensuring database di instansiasi sekali saat ada thread yang beraksi
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, DatabaseConnection::class.java, "sleep").fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}