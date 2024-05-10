package com.example.cachenetworkdb2024.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cachenetworkdb2024.Model.VideoDatabaseModel

@Dao
interface VideoDatabaseDAO {

    /*
    * returning as livedata
    * so it wont block main thread when do query
    * and always update the data returned from the table into UI
    * */
    @Query("select * from videodatabasemodel")
    fun getVideos(): LiveData<List<VideoDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: VideoDatabaseModel)
}