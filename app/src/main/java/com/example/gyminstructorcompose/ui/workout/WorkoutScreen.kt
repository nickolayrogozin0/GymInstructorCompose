package com.example.gyminstructorcompose.ui.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gyminstructorcompose.ui.workout.calendar.Calendar

@Composable
fun WorkoutScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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
        WorkoutExerciseList()
    }
}