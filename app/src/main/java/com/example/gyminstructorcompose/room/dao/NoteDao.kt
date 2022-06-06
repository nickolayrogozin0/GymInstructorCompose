package com.example.gyminstructorcompose.room.dao

import androidx.room.*
import com.example.gyminstructorcompose.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM NOTE WHERE id = :id")
    suspend fun selectNote(id: Int): Note

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}