package com.example.gyminstructorcompose.navigation

import com.example.gyminstructorcompose.R

sealed class GymInstructorScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Workout : GymInstructorScreen(
        route = "workout",
        title = "Workout",
        icon = R.drawable.ic_baseline_work_24
    )

    object Library : GymInstructorScreen(
        route = "library",
        title = "Library",
        icon = R.drawable.ic_baseline_library_books_24
    )

    object Statistics : GymInstructorScreen(
        route = "statistics",
        title = "Statistics",
        icon = R.drawable.ic_baseline_pie_chart_24
    )

    object Account : GymInstructorScreen(
        route = "account",
        title = "Account",
        icon = R.drawable.ic_baseline_person_24
    )

}