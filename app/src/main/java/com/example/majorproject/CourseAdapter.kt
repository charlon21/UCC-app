package com.example.majorproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(
    private var courseList: List<Course>
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    // ViewHolder for a single course item
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseCodeTextView: TextView = itemView.findViewById(R.id.courseCodeTextView)
        val courseNameTextView: TextView = itemView.findViewById(R.id.courseNameTextView)
        val preRequisiteTextView: TextView = itemView.findViewById(R.id.preRequisiteTextView)
        val creditHoursTextView: TextView = itemView.findViewById(R.id.creditHoursTextView)
        val courseDescriptionTextView: TextView = itemView.findViewById(R.id.courseDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val currentItem = courseList[position]
        holder.courseCodeTextView.text = currentItem.courseCode
        holder.courseNameTextView.text = currentItem.courseName
        holder.preRequisiteTextView.text = currentItem.preRequisite
        holder.creditHoursTextView.text = currentItem.creditHours
        holder.courseDescriptionTextView.text = currentItem.description
    }

    override fun getItemCount() = courseList.size

    // Call this method to update the adapter's data from the database
    fun updateCourses(newCourses: List<Course>) {
        this.courseList = newCourses
        notifyDataSetChanged()
    }

}
