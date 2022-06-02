package com.example.gyminstructorcompose.ui.exerciselibrary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseLibraryScreen() {
    Column(
    ) {
        ScreenTopBar()
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
        LazyColumn(
        ) {
            items(10) {
                ExerciseLibraryCard()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseLibraryCard() {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10),
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Squat",
                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                    color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = null,
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Medium",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Compound",
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
fun ScreenTopBar() {
    SmallTopAppBar(
        title = { Text("Exercise library") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Star,
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

@Preview
@Composable
fun ExerciseLibraryCardPreview() {
    ExerciseLibraryCard()
}