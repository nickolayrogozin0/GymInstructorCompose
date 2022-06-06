package com.example.gyminstructorcompose.ui.exerciselibrary

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gyminstructorcompose.R
import com.example.gyminstructorcompose.model.ExerciseInfo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseLibraryScreen(
    navController: NavController,
    viewModel: ExerciseLibraryViewModel = hiltViewModel()
) {

    val favoriteSort = remember {
        mutableStateOf(0)
    }

    val difficultySort = remember {
        mutableStateOf(0)
    }

    val allExercises = remember { viewModel.getAllExerciseInfo() }
    val favoriteExercise = remember {
        viewModel.getFavoriteExercise()
    }
    Log.i("EXERCISE", allExercises.value.size.toString())
    Column(

    ) {
        ScreenTopBar(favoriteSort.value) {
            if (favoriteSort.value == 0) favoriteSort.value =
                1 else favoriteSort.value = 0
        }
        Spacer(modifier = Modifier.height(16.dp))
        SearchField()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DifficultySelector(modifier = Modifier.weight(1f))
            Spacer(Modifier.width(32.dp))
            TypeSelector(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))

        val exerciseList = findExerciseList(favoriteSort.value, difficultySort.value)

        ExerciseList(
            navController = navController,
            exerciseList = if (favoriteSort.value == 0) allExercises else favoriteExercise,
            viewModel = viewModel
        )
    }

}

private fun findExerciseList(favorite: Int, difficulty: Int): MutableState<List<ExerciseInfo>> {
    val sb = StringBuilder()
    if (favorite != 0) sb.append("isFavorite = 1")
    if (difficulty != 0) sb.append("difficulty = $difficulty")

    Log.i("QUERY_TO_USE", sb.toString())

    return mutableStateOf(emptyList())
}


@Composable
fun ExerciseList(
    navController: NavController,
    exerciseList: MutableState<List<ExerciseInfo>>,
    viewModel: ExerciseLibraryViewModel
) {
    LazyColumn()
    {
        items(exerciseList.value.size) { pos ->


            val favoriteIcon = remember {
                mutableStateOf(
                    calcFavoriteIcon(exerciseList.value[pos].isFavorite)
                )
            }


            ExerciseLibraryCard(
                title = exerciseList.value[pos].title,
                difficulty = when (exerciseList.value[pos].difficulty) {
                    0 -> "Easy"
                    1 -> "Medium"
                    2 -> "Hard"
                    else -> "Unknown"
                },
                type = when (exerciseList.value[pos].type) {
                    0 -> "Compound"
                    1 -> "Isolation"
                    else -> "Unknown"
                },
                favoriteIcon = favoriteIcon.value,
                onFavorite = {
                    val faveState = if (exerciseList.value[pos].isFavorite == 0) 1 else 0
                    exerciseList.value[pos].isFavorite = faveState
                    viewModel.updateFavorite(exerciseList.value[pos])
                    favoriteIcon.value = calcFavoriteIcon(faveState)
                },
                onClick = {
                    navController.navigate("exercise_expanded/${exerciseList.value[pos].id}")
                }
            )
        }
    }
}


private fun calcFavoriteIcon(state: Int): Int {
    return when (state) {
        0 -> R.drawable.ic_baseline_star_border_24
        1 -> R.drawable.ic_baseline_star_24
        else -> com.google.android.material.R.drawable.mtrl_ic_error
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseLibraryCard(
    title: String,
    difficulty: String,
    type: String,
    favoriteIcon: Int,
    onClick: () -> Unit,
    onFavorite: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(10),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = onFavorite) {
                    Icon(
                        painter = painterResource(id = favoriteIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = difficulty,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = type,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}


@Composable
fun SearchField() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        singleLine = true,
        label = {
            Text("Exercise title")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DifficultySelector(modifier: Modifier) {
    val options = listOf("Any", "Easy", "Medium", "Hard")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("Difficulty") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TypeSelector(modifier: Modifier) {
    val options = listOf("Any", "Compound", "Isolation")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("Type") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = {
                        Text(selectionOption)
                    },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ScreenTopBar(
    showOnlyFavorite: Int,
    onShowFavoriteChange: () -> Unit
) {

    SmallTopAppBar(
        title = { Text("Exercise library") },
        actions = {
            IconButton(onClick = onShowFavoriteChange) {
                Icon(
                    painter = painterResource(
                        id = when (showOnlyFavorite) {
                            0 -> R.drawable.ic_baseline_star_border_24
                            1 -> R.drawable.ic_baseline_star_24
                            else -> com.google.android.material.R.drawable.mtrl_ic_error
                        }
                    ),
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
}