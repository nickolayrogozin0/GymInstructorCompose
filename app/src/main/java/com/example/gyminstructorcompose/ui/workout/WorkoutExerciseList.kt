package com.example.gyminstructorcompose.ui.workout

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gyminstructorcompose.ui.workout.calendar.Calendar
import com.example.gyminstructorcompose.ui.workout.calendar.CalendarCircle

@Composable
fun WorkoutExerciseList() {
    Surface(
        modifier = Modifier
//            .padding(16.dp, 0.dp, 16.dp, 0.dp),
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
        modifier = Modifier
            .padding(16.dp, 8.dp, 16.dp, 8.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(10)
    ) {
        Column {
            WorkoutExerciseItemLabel()
            WorkoutExerciseItemLoadLabel()
//            WorkoutExerciseItemLoad()
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
            Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = null)
        }
    }

}

@Composable
fun WorkoutExerciseItemLoadLabel() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Text(
            text = "Reps",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Sets",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Load",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "RPE",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "%1RM",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Preview
@Composable
fun WorkoutExerciseItemPreview() {
    WorkoutExerciseItem()
}
