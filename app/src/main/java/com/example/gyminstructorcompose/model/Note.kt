package com.example.gyminstructorcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id : Int,
    var title : String,
    var body : String
)
