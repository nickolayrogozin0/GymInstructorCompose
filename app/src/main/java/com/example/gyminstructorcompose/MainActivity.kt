package com.example.gyminstructorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gyminstructorcompose.ui.theme.GymInstructorComposeTheme
import com.example.gyminstructorcompose.ui.workout.WorkoutScreen
import com.example.gyminstructorcompose.ui.workout.calendar.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymInstructorComposeTheme {
                Surface() {
                    // A surface container using the 'background' color from the theme
                    WorkoutScreen()
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GymInstructorComposeTheme {
        WorkoutScreen()
    }
}