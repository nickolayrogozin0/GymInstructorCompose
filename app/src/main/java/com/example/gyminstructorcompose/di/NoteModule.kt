package com.example.gyminstructorcompose.di

import android.content.Context
import androidx.room.Room
import com.example.gyminstructorcompose.room.NOTES_MIGRATION_1_2
import com.example.gyminstructorcompose.room.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_database"
        )
            .addMigrations(NOTES_MIGRATION_1_2)
            .build()
    }

}