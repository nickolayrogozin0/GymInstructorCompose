package com.example.gyminstructorcompose.ui.notes

import com.example.gyminstructorcompose.model.Note
import com.example.gyminstructorcompose.room.NoteDatabase
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val database: NoteDatabase
) {

    suspend fun getAll() : List<Note> {
        return database.getNoteDao().getAllNotes()
    }

    suspend fun selectNote(id: Int): Note {
        return database.getNoteDao().selectNote(id)
    }

    suspend fun insertNote(note: Note){
        database.getNoteDao().insertNote(note)
    }

    suspend fun updateNote(note: Note){
        database.getNoteDao().updateNote(note)
    }

    suspend fun deleteNote(note: Note){
        database.getNoteDao().deleteNote(note)
    }

}