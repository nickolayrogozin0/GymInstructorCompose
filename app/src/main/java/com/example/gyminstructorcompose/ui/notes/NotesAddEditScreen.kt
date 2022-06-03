package com.example.gyminstructorcompose.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NotesAddEditScreen(
    navController: NavController,
    noteId: Int
) {
    Column(

    ) {

        var title by remember {
            mutableStateOf("")
        }

        var body by remember {
            mutableStateOf("")
        }

        if (noteId == -1) NotesAddTopAppBar(navController = navController) else {
            NotesEditTopAppBar(navController = navController)
            //take note from db
        }

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            label = { Text("Title") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = body,
            onValueChange = { body = it },
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
            ,
            label = { Text("Content") }
        )
    }


}

@Composable
fun NotesAddTopAppBar(
    navController: NavController,
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "more button"
                )
            }
        }
    )
}

@Composable
fun NotesEditTopAppBar(
    navController: NavController,
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "more button"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "more button"
                )
            }
        }
    )
}