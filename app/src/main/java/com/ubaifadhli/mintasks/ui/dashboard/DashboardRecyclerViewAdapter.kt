package com.ubaifadhli.mintasks.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.data.model.Task

class DashboardRecyclerViewAdapter(
    private val tasks: ArrayList<Task>,
    private val mainContext: Context,
    private val listener : PresenterHelperListener
) : RecyclerView.Adapter<TaskViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.task_viewholder,
            parent,
            false
        )

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        var currentTask = tasks.get(position)

        holder.ownerCheckbox.isChecked = currentTask.isOwnerChecked

        holder.taskNameTV.text = currentTask.name
        holder.taskDueDateTV.text = currentTask.dueDate

        holder.ownerCheckbox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                currentTask.isOwnerChecked = !currentTask.isOwnerChecked
                listener.onCheckboxClicked(currentTask.id)
                notifyDataSetChanged()
            }
        })

        holder.textLayout.setOnClickListener {
            listener.onCheckboxClicked(currentTask.id)
        }

        holder.deleteImageButton.setOnClickListener {
            listener.onDeleteImageButtonClicked(currentTask.id)
            deleteTaskAt(position)
        }

        holder.shareImageButton.setOnClickListener {
            listener.onShareImageButtonClicked(currentTask.id)
        }

    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun addTask(task: Task) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    fun deleteTaskAt(position: Int) {
        tasks.removeAt(position)
        notifyDataSetChanged()
    }
}