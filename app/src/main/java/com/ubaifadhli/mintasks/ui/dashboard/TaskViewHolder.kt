package com.ubaifadhli.mintasks.ui.dashboard

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubaifadhli.mintasks.R


class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var ownerCheckbox = itemView.findViewById(R.id.task_owner_checkbox) as CheckBox
    var taskNameTV = itemView.findViewById(R.id.task_name_textview) as TextView
    var taskDueDateTV = itemView.findViewById(R.id.task_due_date_textview) as TextView
    var textLayout = itemView.findViewById(R.id.task_text_layout) as LinearLayout
    var deleteImageButton = itemView.findViewById(R.id.task_delete_imagebutton) as ImageButton
    var shareImageButton = itemView.findViewById(R.id.task_share_imagebutton) as ImageButton


}