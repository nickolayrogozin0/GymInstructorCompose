package com.example.gyminstructorcompose.ui.workout.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gyminstructorcompose.ui.theme.GymInstructorComposeTheme

@Composable
fun Calendar(

) {

    val viewModel = remember {
        CalendarViewModel()
    }

    var weekValues = remember {
        viewModel.getWeekValues()
    }

    Surface(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(10)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {
                    viewModel.decreaseWeek()
                    weekValues =
                        viewModel.getWeekValues()
                }) {
                    Icon(imageVector = Icons.Default.ChevronLeft, contentDescription = null)
                }
                Text(
                    "Week ${viewModel.currentWeek.value}",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = {
                    viewModel.increaseWeek()
                    weekValues =
                        viewModel.getWeekValues()

                }) {
                    Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp, 24.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                items(7) { index ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = viewModel.listOfWeekdays[index],
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(32.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        var backgroundColor = MaterialTheme.colorScheme.surface
                        var textColor = MaterialTheme.colorScheme.onSurface

                        if (index == viewModel.currentDay.value) {
                            backgroundColor = MaterialTheme.colorScheme.primary
                            textColor = MaterialTheme.colorScheme.onPrimary
                        }

                        CalendarCircle(
                            index = weekValues[index].toString(),
                            backgroundColor = backgroundColor,
                            textColor = textColor
                        ) {
                            viewModel.currentDay.value = index
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun CalendarCircle(
    index: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .background
                (
                color = backgroundColor,
                shape = CircleShape
            )
            .size(32.dp)
            .clickable {
                onClick(index.toInt())
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = index,
            style = MaterialTheme.typography.labelLarge,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    GymInstructorComposeTheme {
        Calendar()
    }
}