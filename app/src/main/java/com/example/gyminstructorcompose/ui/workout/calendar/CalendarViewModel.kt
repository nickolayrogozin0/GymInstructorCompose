package com.example.gyminstructorcompose.ui.workout.calendar


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalendarViewModel : ViewModel() {
    private val calendar = mutableStateOf(java.util.Calendar.getInstance())

    private val listOfMonthDays = mutableListOf<Int>()
//    private val currentYearWeek = mutableStateOf(calendar.value.weekYear)


    val listOfWeekdays = when (calendar.value.firstDayOfWeek) {
        1 -> listOf("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat")
        2 -> listOf("Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun")
        7 -> listOf("Sat", "Sun", "Mon", "Tue", "Wen", "Thu", "Fri")
        else -> emptyList()
    }

    val currentDay = mutableStateOf(0)
    val currentWeek = mutableStateOf(1)
    private val maxWeeks = mutableStateOf(4)

    fun getWeekValues(): List<Int> {
        repeat(calendar.value[java.util.Calendar.DAY_OF_WEEK] - calendar.value.firstDayOfWeek) {
            calendar.value.add(java.util.Calendar.DAY_OF_MONTH, -1)
        }
        listOfMonthDays.clear()
        repeat(7) {
            listOfMonthDays.add(calendar.value.get(java.util.Calendar.DAY_OF_MONTH))
            calendar.value.add(java.util.Calendar.DAY_OF_MONTH, 1)
        }
        calendar.value.add(java.util.Calendar.DAY_OF_MONTH, -7)
        return listOfMonthDays
    }

    fun decreaseWeek(): Int {
        if (currentWeek.value == 1) return currentWeek.value
        currentWeek.value -= 1
        calendar.value.add(java.util.Calendar.DAY_OF_MONTH, -7)
        return currentWeek.value
    }

    fun increaseWeek(): Int {
        if (currentWeek.value == maxWeeks.value) return currentWeek.value
        currentWeek.value += 1
        calendar.value.add(java.util.Calendar.DAY_OF_MONTH, 7)
        return currentWeek.value
    }

}
