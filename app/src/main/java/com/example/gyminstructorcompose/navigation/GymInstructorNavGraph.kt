package com.example.gyminstructorcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gyminstructorcompose.ui.account.UserAccountScreen
import com.example.gyminstructorcompose.ui.exerciselibrary.ExerciseExpandedScreen
import com.example.gyminstructorcompose.ui.exerciselibrary.ExerciseLibraryScreen
import com.example.gyminstructorcompose.ui.notes.NotesAddEditScreen
import com.example.gyminstructorcompose.ui.notes.NotesListScreen
import com.example.gyminstructorcompose.ui.statistics.StatisticsScreen
import com.example.gyminstructorcompose.ui.workout.WorkoutScreen

@Composable
fun GymInstructorNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = GymInstructorScreen.Workout.route
    ) {
        composable(route = GymInstructorScreen.Workout.route) {
            WorkoutScreen(
                navController
            )
        }
        composable(route = GymInstructorScreen.Library.route) {
            ExerciseLibraryScreen(
                navController
            )
        }
        composable(route = GymInstructorScreen.Statistics.route) {
            StatisticsScreen()
        }
        composable(route = GymInstructorScreen.Account.route) {
            UserAccountScreen()
        }
        composable(route = GymInstructorScreen.ExerciseExpanded.route){
            ExerciseExpandedScreen()
        }
        
        composable("notes"){
            NotesListScreen(navController = navController)
        }

        composable(
            "notes_add_edit/{noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.IntType
                }
            )
        ) {
            val noteId = remember {
                it.arguments?.getInt("noteId")
            }
            NotesAddEditScreen(
                navController = navController,
                noteId = noteId ?: -1,
            )
        }
    }
}