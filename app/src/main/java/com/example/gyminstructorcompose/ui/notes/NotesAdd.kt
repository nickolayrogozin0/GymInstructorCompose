package com.example.gyminstructorcompose.ui.notes


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gyminstructorcompose.model.Note


@Composable
fun AddNoteScreen(
    navController: NavController,
    viewModel: NoteViewModel = hiltViewModel()
) {
    var title by remember {
        mutableStateOf("")
    }

    var text by remember {
        mutableStateOf("")
    }

    Column() {
        NotesAddTopAppBar(navController = navController) {
            viewModel.insertNote(Note(0, title, text))
            navController.popBackStack()
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
fun NotesAddTopAppBar(
    navController: NavController,
    onInsert: () -> Unit
) {
    SmallTopAppBar(
        title = { Text("Add note") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onInsert) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "more button"
                )
            }
        }
    )
}