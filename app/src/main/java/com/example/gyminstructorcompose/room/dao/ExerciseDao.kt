package com.example.gyminstructorcompose.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM ExerciseInfo")
    suspend fun getAllShort(): List<ExerciseInfo>

    @Query("SELECT * FROM ExerciseInfoExtended WHERE id = :id")
    suspend fun getExtended(id: Int): ExerciseInfoExtended

    @Update
    suspend fun updateFavorite(exerciseInfo: ExerciseInfo)

}