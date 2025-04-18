package com.example.majorproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StaffDirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_directory)

        val staffList = listOf(
            StaffMember(
                "Otis Osbourne",
                "Head Of Department",
                "876-578-0804",
                "itfaculty@ucc.edu.jm",
                R.drawable.otis_osbourne
            ),
            StaffMember(
                "Craig Wilmot",
                "IT Coordinator",
                "876-906-3000",
                "itprogofficer4@ucc.edu.jm",
                R.drawable.craig_wilmot
            ),
            StaffMember(
                "Stefan Watson",
                "Lecturer",
                "876-765-4321",
                "swatson@faculty.ucc.edu.jm",
                R.drawable.stefan_watson
            ),
            StaffMember(
                "Sajjad Rizvi",
                "Lecturer",
                "876-906-3000",
                "srizvi@faculty.ucc.edu.jm",
                R.drawable.sajjad_rizvi
            ),
            StaffMember(
                "Neil Williams",
                "Lecturer",
                "876-906-3000",
                "itlecturer@ucc.edu.jm",
                R.drawable.neil_williams
            )
        )



        val recyclerView = findViewById<RecyclerView>(R.id.staffRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = StaffAdapter(staffList)
        recyclerView.adapter = adapter
    }
}
