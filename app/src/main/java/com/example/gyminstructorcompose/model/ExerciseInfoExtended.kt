package com.example.gyminstructorcompose.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys =
    [
        ForeignKey(
            entity = ExerciseInfo::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ExerciseInfoExtended(
    @PrimaryKey val id: Int,
    val targetMuscles: String,
    val loadAdvice: String,
    val url: String
)
