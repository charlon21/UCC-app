package com.example.majorproject

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StaffAdapter(private val staffList: List<StaffMember>) :
    RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {

    class StaffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val staffNameTextView: TextView = itemView.findViewById(R.id.staffNameTextView)
        val staffTitleTextView: TextView = itemView.findViewById(R.id.staffTitleTextView)
        val staffTelephoneTextView: TextView = itemView.findViewById(R.id.staffTelephoneTextView)
        val staffEmailTextView: TextView = itemView.findViewById(R.id.staffEmailTextView)
        val staffImageView: ImageView = itemView.findViewById(R.id.staffImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.staff_member_item, parent, false)
        return StaffViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        val currentItem = staffList[position]
        holder.staffNameTextView.text = currentItem.name
        holder.staffTitleTextView.text = currentItem.title
        holder.staffTelephoneTextView.text = currentItem.telephone
        holder.staffEmailTextView.text = currentItem.email
        holder.staffImageView.setImageResource(currentItem.imageResId)


        // Set click listener for telephone
        holder.staffTelephoneTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${currentItem.telephone}")
            }
            holder.itemView.context.startActivity(intent)
        }

        // Set click listener for email
        holder.staffEmailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${currentItem.email}")
                putExtra(Intent.EXTRA_SUBJECT, "Subject")
                putExtra(Intent.EXTRA_TEXT, "Body")
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = staffList.size
}
