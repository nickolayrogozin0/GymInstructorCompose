package com.example.gyminstructorcompose.ui.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import com.example.gyminstructorcompose.R
import com.example.gyminstructorcompose.model.Note


@Composable
fun NotesEditScreen(
    navController: NavController,
    viewModel: NoteViewModel = hiltViewModel(),
    noteId : Int
) {
    val note = viewModel.selectNote(noteId)

    var title by remember {
        mutableStateOf(note.title)
    }

    var text by remember {
        mutableStateOf(note.body)
    }

    Column() {
        Text("$noteId $note")
        NotesEditTopAppBar(navController = navController, onSave = { viewModel.updateNote(Note(note.id, title, text)) }) {
            viewModel.deleteNote(note)
        }
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            label = {Text("Title")}
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            label = {Text("Text")}
        )
    }

}


@Composable
fun NotesEditTopAppBar(
    navController: NavController,
    onSave: () -> Unit,
    onDelete: () -> Unit,
) {
    SmallTopAppBar(
        title = { Text("Edit note") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onSave) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_save_24),
                    contentDescription = "more button"
                )
            }
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "more button"
                )
            }
        }
    )
}