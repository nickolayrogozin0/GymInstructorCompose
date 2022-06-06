package com.example.gyminstructorcompose.ui.exerciselibrary

import androidx.lifecycle.LiveData
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended
import com.example.gyminstructorcompose.room.ExerciseDatabase
import javax.inject.Inject

class ExerciseLibraryRepository @Inject constructor(
    private val database: ExerciseDatabase
) {

     suspend fun getAllShort(): List<ExerciseInfo> {
        return database.exerciseDao().getAllShort()
    }

    suspend fun getExtended(id : Int) : ExerciseInfoExtended {
        return database.exerciseDao().getExtended(id)
    }

    suspend fun updateFavorite(exerciseInfo: ExerciseInfo) {
        database.exerciseDao().updateFavorite(exerciseInfo)
    }

    suspend fun getFavoriteExercise(): List<ExerciseInfo> {
        return database.exerciseDao().getFavoriteExercise()
    }

}