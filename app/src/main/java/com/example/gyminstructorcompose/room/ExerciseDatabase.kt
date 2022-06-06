package com.example.gyminstructorcompose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.gyminstructorcompose.model.ExerciseInfo
import com.example.gyminstructorcompose.model.ExerciseInfoExtended
import com.example.gyminstructorcompose.room.dao.ExerciseDao

@Database(
    entities = [
        ExerciseInfo::class,
        ExerciseInfoExtended::class
    ],
    version = 2,
    exportSchema = true
)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun exerciseDao() : ExerciseDao
}

val EXERCISE_LIBRARY_MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE ExerciseInfo ADD COLUMN isFavorite INTEGER NOT NULL DEFAULT 0")
    }
}