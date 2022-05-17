package com.example.gyminstructorcompose.ui.workout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutExerciseList() {
    Surface(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
    ) {
        LazyColumn() {
            items(7) {
                WorkoutExerciseItem()
            }
        }
    }
}

@Composable
fun WorkoutExerciseItem() {
    Surface(
        shadowElevation = 5.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
//                Box(),
//                Text(),
                IconButton(onClick = { /*TODO*/ }) {
                    
                }
                IconButton(onClick = { /*TODO*/ }) {

                }
            }


        }


    }
}

@Preview
@Composable
fun WorkoutExerciseItemPreview() {
    WorkoutExerciseItem()
}
