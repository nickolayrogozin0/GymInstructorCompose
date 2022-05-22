package com.example.gyminstructorcompose.ui.workout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gyminstructorcompose.ui.workout.calendar.CalendarCircle

@Composable
fun WorkoutExerciseList() {
    Surface(
        modifier = Modifier
//            .padding(16.dp, 0.dp, 16.dp, 0.dp),
    ) {
        Column(Modifier.fillMaxSize(), content = {

        })
    }
}

@Composable
fun WorkoutExerciseItem() {
    Surface(
        modifier = Modifier
            .padding(16.dp, 8.dp, 16.dp, 8.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(10)
    ) {
        Column {
            WorkoutExerciseItemLabel()
            WorkoutExerciseItemLoad(
                listOfValues = listOf(
                    "Reps",
                    "Sets",
                    "Load",
                    "RPE",
                    "%1RM"
                )
            )
            Column(

            ) {
                repeat(3) {
                    WorkoutExerciseItemLoad(
                        listOfValues = listOf(
                            "5",
                            "5",
                            "100",
                            "-",
                            "50"
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun WorkoutExerciseItemLabel() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 12.dp, 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CalendarCircle(
            index = "A",
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Squat",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(imageVector = Icons.Default.RadioButtonUnchecked, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
        }
    }

}

@Composable
fun WorkoutExerciseItemLoad(
    listOfValues : List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = listOfValues[it],
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}

@Preview
@Composable
fun WorkoutExerciseItemPreview() {
    WorkoutExerciseItem()
}
