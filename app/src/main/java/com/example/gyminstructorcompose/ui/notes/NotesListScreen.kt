package com.example.gyminstructorcompose.ui.notes

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
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {NotesListScreenTopAppBar(navController = navController)},
        floatingActionButton = {FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "add note")
        }},
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(5) { pos ->
                NoteItem(
                    pos,
                    onClick = {
                        navController.navigate(
                            "notes_add_edit/$it"
                        )
                    }
                )
            }
        }
    }

//    Scaffold(
//        topBar = { NotesListScreenTopAppBar(navController = navController) },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Default.Edit, contentDescription = "add note")
//            }
//        },
//        content = { paddingValues ->
//            LazyColumn(
//                modifier = Modifier.padding(paddingValues)
//            ) {
//                items(7) {
//                    NoteItem(
//                        it,
//                        onClick = {
//                            navController.navigate(
//                                "notes_add_edit/$it"
//                            )
//                        }
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                }
//            }
//        }
//    )
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