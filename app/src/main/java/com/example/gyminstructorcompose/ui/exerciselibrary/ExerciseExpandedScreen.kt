package com.example.gyminstructorcompose.ui.exerciselibrary

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.text.StringBuilder

@Composable
fun ExerciseExpandedScreen(
    navController: NavController,
    exerciseId : Int
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            ExerciseExpandedScreenTopBar(navController = navController)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column() {
                    Text(text = "Squat", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text(text = "Medium", style = MaterialTheme.typography.labelLarge)
                        Spacer(modifier = Modifier.width(32.dp))
                        Text(text = "Compound", style = MaterialTheme.typography.labelLarge)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Target muscle groups",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    val sb = StringBuilder()

                    repeat(15) {
                        sb.append("Muscle #$it")
                    }

                    Text(text = sb.toString(), style = MaterialTheme.typography.labelLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Load advice", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This is only advice, not call to action. Use at your own risk and always listen to your body!",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed molestie augue quis tortor condimentum eleifend. Donec molestie nulla a porta posuere. Etiam mi sapien, ultrices non varius vitae, aliquet eget dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce vitae nibh vitae nulla blandit sagittis. Donec ac purus turpis.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }
}

@Composable
fun ExerciseExpandedScreenTopBar(navController: NavController) {
    SmallTopAppBar(
        title = { Text("Exercise") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "more button"
                )
            }
        }
    )
}