// AdmissionsActivity.kt
package com.example.majorproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Button

class AdmissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admissions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.admissions_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val descriptionTextView: TextView = findViewById(R.id.admissionsDescriptionTextView)
        val linkButton: Button = findViewById(R.id.admissionsLinkButton)

        val description = "ENTRY REQUIREMENTS FOR JAMAICAN STUDENTS\n" +
                "To be unconditionally admitted to complete UCC undergraduate programmes, individuals should possess a minimum of five (5) subjects at the GCE or CSEC level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, 3 respectively. A CSEC pass at level 3 must have been obtained since 1998.\n" +
                "Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects or can opt to do UCC replacement courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting.\n" +
                "Candidates can opt to apply under the Mature Entry option. To be accepted, applicants must be working for 5 years or more and be at a minimum age of 25 years. Academic qualifications, a detailed resume, a job letter and 3 professional references will be required.\n"
        "HONOURS PROGRAMME\n" +
                "Students with 8 CXC/GCE subjects including Mathematics and English Language at Grade 1 may be eligible for a 25% tuition waiver during the first year.\n" +
                "Terms & Conditions\n"
        val url = "https://ucc.edu.jm/apply/undergraduate/preform"

        descriptionTextView.text = description

        linkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
