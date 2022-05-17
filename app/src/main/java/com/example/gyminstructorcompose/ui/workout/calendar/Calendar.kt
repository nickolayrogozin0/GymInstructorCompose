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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gyminstructorcompose.ui.theme.GymInstructorComposeTheme

@Composable
fun Calendar() {
    val currentDay = remember {
        mutableStateOf(0)
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

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ChevronLeft, contentDescription = null)
                }
                Text(
                    "Week 1",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(7) { index ->
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clickable(
                                onClick = {
                                    currentDay.value = index
                                }
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (index == currentDay.value) {
                            Box(
                                modifier = Modifier
                                    .background
                                        (
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                                    .size(32.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$index",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        } else {
                            Text(
                                text = "$index",
                                style = MaterialTheme.typography.labelLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    GymInstructorComposeTheme {
        Calendar()
    }
}