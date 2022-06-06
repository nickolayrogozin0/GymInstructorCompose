package com.example.gyminstructorcompose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended
import com.example.gyminstructorcompose.room.dao.ExerciseDao

@Database(
    entities = [
        ExerciseInfo::class,
        ExerciseInfoExtended::class
    ],
    version = 1,
    exportSchema = true
)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun exerciseDao() : ExerciseDao
}