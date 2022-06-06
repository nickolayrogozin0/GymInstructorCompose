package com.example.gyminstructorcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseInfo(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val title : String,
    val difficulty : Int,
    val type : Int,
)
