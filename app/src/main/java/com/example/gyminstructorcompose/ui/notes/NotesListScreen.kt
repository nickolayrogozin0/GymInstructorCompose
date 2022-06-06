package com.example.gyminstructorcompose.ui.notes

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(
    navController: NavController,
    viewModel: NoteViewModel = hiltViewModel()
) {

    val allNotes = viewModel.getAll()

    Log.i("NOTES_SIZE", allNotes.size.toString())

    Scaffold(
        topBar = {NotesListScreenTopAppBar(navController = navController)},
        floatingActionButton = {FloatingActionButton(onClick = {
            navController.navigate("notes_add")
        }) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "add note")
        }},
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .padding(16.dp)) {
            items(allNotes.size) { pos ->
                NoteItem(
                    allNotes[pos].id,
                    allNotes[pos].title,
                    allNotes[pos].body
                ) {
                    navController.navigate(
                        "notes_add_edit/${allNotes[pos].id}"
                    )
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }

}


@Composable
fun NoteItem(
    noteId: Int,
    noteTitle: String = "Title is very simple",
    noteBody: String = "But text is way harder you know, so we keep just first hundred symbols, so everything you write will be kept but not displayed!",
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(

        ) {
            Text(text = "#$noteId", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = noteTitle, style = MaterialTheme.typography.titleMedium)
        }
        Text(text = noteBody, style = MaterialTheme.typography.bodySmall)
    }

}

@Composable
fun NotesListScreenTopAppBar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text("Notes") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "more button"
                )
            }
        }
    )
}