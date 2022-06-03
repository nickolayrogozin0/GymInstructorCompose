package com.example.gyminstructorcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class GymInstructorScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Workout : GymInstructorScreen(
        route = "workout",
        title = "Workout",
        icon = Icons.Default.Work
    )

    object Library : GymInstructorScreen(
        route = "library",
        title = "Library",
        icon = Icons.Default.LibraryBooks
    )

    object Statistics : GymInstructorScreen(
        route = "statistics",
        title = "Statistics",
        icon = Icons.Default.PieChart
    )

    object Account : GymInstructorScreen(
        route = "account",
        title = "Account",
        icon = Icons.Default.Person
    )

    object ExerciseExpanded : GymInstructorScreen(
        route = "exerciseExpanded",
        title = "Exercise",
        icon = Icons.Default.Info
    )

}