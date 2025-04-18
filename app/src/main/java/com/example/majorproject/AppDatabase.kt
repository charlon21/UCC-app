package com.example.majorproject

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Course::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}
