package com.example.majorproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey val courseCode: String,
    val courseName: String,
    val preRequisite: String,
    val creditHours: String,
    val description: String
)
