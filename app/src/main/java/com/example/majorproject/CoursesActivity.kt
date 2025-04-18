package com.example.majorproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.majorproject.AppDatabase
import com.example.majorproject.Course
import com.example.majorproject.DatabaseProvider

class CoursesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_courses)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.courses_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.coursesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CourseAdapter(emptyList())
        recyclerView.adapter = adapter

        // Correct way to get Room database instance
        db = DatabaseProvider.getDatabase(this)

        lifecycleScope.launch {
            var courses = withContext(Dispatchers.IO) {
                db.courseDao().getAllCourses()
            }

            if (courses.isEmpty()) {
                val defaultCourses = getDefaultCourses()
                withContext(Dispatchers.IO) {
                    db.courseDao().insertCourses(defaultCourses)
                }
                courses = defaultCourses
            }

            adapter.updateCourses(courses)
        }
    }

    private fun getDefaultCourses() = listOf(
        Course("ITT107", "Computer Information Essentials", "PreReq:N/A", "Credits:3", "Introduction to Computer Systems"),
        Course("ITT103", "Programming Techniques", "PreReq:N/A", "Credits:3", "Introduction to Programming"),
        Course("ITT201", "Data Communication 1", "PreReq:Computer Information Essentials", "Credits:3", "Principles of Data Transfer"),
        Course("ITT403", "Data Communication 2", "PreReq:Data Communication 1", "Credits:3", "Principles of Data Transfer"),
        Course("ITT116", "Computer Essentials and Troubleshooting 1", "PreReq:Computer Information Essentials", "Credits:3", "Troubleshooting Computer Systems"),
        Course("ITT216", "Computer Essentials and Troubleshooting 2", "PreReq:Computer Essentials and Troubleshooting 1", "Credits:3", "Introduction to Computer Systems"),
        Course("ITT200", "Object Oriented Programming C++", "PreReq:Programming Techniques", "Credits:3", "C++ Programming"),
        Course("ITT209", "Building an Application with C#", "PreReq:Object Oriented Programming C++", "Credits:3", "Creating Apps in C#"),
        Course("ITT310", "System Analysis and Design", "PreReq:N/A", "Credits:3", "Designing Information Systems"),
        Course("ITT306", "IT Audit and Controls", "PreReq:System Analysis and Design", "Credits:3", "Procedures on IT Risk Management")
    )
}
