package com.example.gyminstructorcompose.modules

import android.content.Context
import androidx.room.Room
import com.example.gyminstructorcompose.room.ExerciseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExerciseModule {

    @Provides
    @Singleton
    fun provideExerciseDatabase(
        @ApplicationContext context: Context
    ): ExerciseDatabase {
        return Room.databaseBuilder(
            context,
            ExerciseDatabase::class.java,
            "exercise_database"
        )
            .createFromAsset("database/exercise_database.db")
            .build()
    }

}