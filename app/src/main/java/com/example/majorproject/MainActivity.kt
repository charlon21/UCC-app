
package com.example.majorproject

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find and set click listener for the Staff/Faculty button
        val staffButton = findViewById<ConstraintLayout>(R.id.staffButton)
        staffButton?.setOnClickListener {
            val intent = Intent(this, StaffDirectoryActivity::class.java)
            startActivity(intent)
        }

        // Find and set click listener for the courses button
        val coursesButton = findViewById<ConstraintLayout>(R.id.coursesButton)
        coursesButton?.setOnClickListener {
            val intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
        }

        // Find the Admissions button by its ID
        val admissionsButton = findViewById<ConstraintLayout>(R.id.admissionsButton)
        admissionsButton?.setOnClickListener {
            // Create an Intent to start the AdmissionsActivity
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
        }
        // Find the Social Media button and set a click listener
        val socialMediaButton = findViewById<ConstraintLayout>(R.id.socialMediaButton)
        socialMediaButton.setOnClickListener {
            showSocialMediaOptions()
        }

        val emailFAB = findViewById<FloatingActionButton>(R.id.emailFAB)
        emailFAB.setOnClickListener {
            sendEmailToHOD()
        }
    }

    private fun showSocialMediaOptions() {
        val options = arrayOf("Facebook", "Twitter", "Instagram")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose a platform")
        builder.setItems(options) { _, which ->
            val url = when (which) {
                0 -> "https://www.facebook.com/uccjamaica"
                1 -> "https://twitter.com/uccjamaica"
                2 -> "https://www.instagram.com/uccjamaica"
                else -> null
            }
            url?.let { openWebPage(it) }
        }
        builder.show()
    }

    private fun openWebPage(url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }

    private fun sendEmailToHOD() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:itfaculty@ucc.edu.jm")
            setPackage("com.google.android.gm")
            putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            putExtra(Intent.EXTRA_TEXT, "Dear Head of Department,")
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Gmail app not found.", Toast.LENGTH_SHORT).show()
        }
    }



    }

