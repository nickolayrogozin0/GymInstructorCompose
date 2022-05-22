package com.example.gyminstructorcompose.ui.workout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import com.example.gyminstructorcompose.ui.workout.calendar.Calendar


@Composable
fun WorkoutScreen(

) {
    Column()
    {
        SmallTopAppBar(
            title = { Text("Workout") },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "more button"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "more button"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Calendar()
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(Modifier.weight(1f)) {
            items(7) {
                WorkoutExerciseItem()
            }
        }
    }
}

