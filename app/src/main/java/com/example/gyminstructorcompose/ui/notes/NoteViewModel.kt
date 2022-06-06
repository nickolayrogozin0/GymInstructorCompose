package com.example.gyminstructorcompose.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gyminstructorcompose.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val allNotes = mutableListOf<Note>()
    private var note : Note? = null

    fun getAll(): List<Note> {
        viewModelScope.launch {
            allNotes.clear()
            allNotes.addAll(repository.getAll())
        }
        return allNotes
    }

    fun selectNote(id : Int) : Note {
        viewModelScope.launch {
            note = repository.selectNote(id)
        }
        return if (note != null) note!! else Note(-1, "", "")
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

}