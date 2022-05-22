package com.example.gyminstructorcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gyminstructorcompose.ui.account.UserAccountScreen
import com.example.gyminstructorcompose.ui.exerciselibrary.ExerciseLibraryScreen
import com.example.gyminstructorcompose.ui.statistics.StatisticsScreen
import com.example.gyminstructorcompose.ui.workout.WorkoutScreen

@Composable
fun GymInstructorNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = GymInstructorScreen.Workout.route
    ) {
        composable(route = GymInstructorScreen.Workout.route) {
            WorkoutScreen()
        }
        composable(route = GymInstructorScreen.Library.route) {
            ExerciseLibraryScreen()
        }
        composable(route = GymInstructorScreen.Statistics.route) {
            StatisticsScreen()
        }
        composable(route = GymInstructorScreen.Account.route) {
            UserAccountScreen()
        }
    }
}