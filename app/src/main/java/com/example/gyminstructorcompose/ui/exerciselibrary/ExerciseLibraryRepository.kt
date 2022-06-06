package com.example.gyminstructorcompose.ui.exerciselibrary

import android.util.Log
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended
import com.example.gyminstructorcompose.room.ExerciseDatabase
import javax.inject.Inject

class ExerciseLibraryRepository @Inject constructor(
    private val database: ExerciseDatabase
) {

    suspend fun getAllShort() : List<ExerciseInfo> {
        val allExercise = database.exerciseDao().getAllShort()
        Log.i("EXERCISE_REPO", allExercise.size.toString())
        return allExercise
    }

    suspend fun getExtended(id : Int) : ExerciseInfoExtended {
        return database.exerciseDao().getExtended(id)
    }

    suspend fun updateFavorite(exerciseInfo: ExerciseInfo) {
        database.exerciseDao().updateFavorite(exerciseInfo)
    }

}