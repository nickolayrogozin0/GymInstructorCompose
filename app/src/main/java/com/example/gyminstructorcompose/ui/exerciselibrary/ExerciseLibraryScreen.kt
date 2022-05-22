package com.example.gyminstructorcompose.ui.exerciselibrary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
                .padding(start = 16.dp, end = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DifficultySelector(modifier = Modifier.weight(1f))
            Spacer(Modifier.width(32.dp))
            TypeSelector(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
        ){
            items(10){
                ExerciseLibraryCard()
            }
        }
    }
}

@Composable
fun ExerciseLibraryCard() {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(10),
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
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
                    style = androidx.compose.material3.MaterialTheme.typography.labelLarge,
                    color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Compound",
                    style = androidx.compose.material3.MaterialTheme.typography.labelLarge,
                    color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
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
        onValueChange = {text = it},
        singleLine = true,
        label = {
            Text("Exercise title")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant,
            cursorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            focusedLabelColor = androidx.compose.material3.MaterialTheme.colorScheme.primary
        )
    )
}

@OptIn(ExperimentalMaterialApi::class)
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
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                textColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                trailingIconColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant,
                focusedTrailingIconColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                cursorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                focusedLabelColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceVariant,
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ){
                    Text(selectionOption)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
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
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                textColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                trailingIconColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant,
                focusedTrailingIconColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                cursorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                focusedLabelColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceVariant,
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ){
                    Text(selectionOption)
                }
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