package com.ubaifadhli.mintasks.ui.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.ui.base.BaseFragment
import com.ubaifadhli.mintasks.ui.taskcreateupdate.TaskCreateUpdateActivity
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager

class DashboardFragment : BaseFragment(R.layout.fragment_dashboard), DashboardContract.DashboardView, PresenterHelperListener {
    lateinit var taskRecyclerView: RecyclerView
    lateinit var addTaskFloatingActionButton: FloatingActionButton

    lateinit var presenter : DashboardPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskRecyclerView = view.findViewById(R.id.dashboard_recyclerview)
        addTaskFloatingActionButton = view.findViewById(R.id.dashboard_add_task_fab)

        setPresenter(DashboardPresenter(this))

        presenter.getTasks(context!!)

        addTaskFloatingActionButton.setOnClickListener { onAddTaskFABClicked() }


    }

    override fun setRecyclerViewAdapter(tasks: ArrayList<Task>) {
        taskRecyclerView.layoutManager = LinearLayoutManager(context)
        taskRecyclerView.adapter = DashboardRecyclerViewAdapter(tasks, context!!, this)
    }

    override fun onAddTaskFABClicked() {
        var intent = Intent(context, TaskCreateUpdateActivity::class.java)
        intent.putExtra("requestCode", CREATE_TASK_RC)


        startActivityForResult(intent, CREATE_TASK_RC)
    }


    override fun navigateToActivity(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: DashboardContract.DashboardPresenter) {
        this.presenter = presenter as DashboardPresenter
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetailActivity(id: String) {
        var intent = Intent(context, TaskCreateUpdateActivity::class.java)
        intent.putExtra("taskID", id)
        intent.putExtra("requestCode", UPDATE_TASK_RC)

        startActivityForResult(intent, UPDATE_TASK_RC)
    }

    override fun onCheckboxClicked(id: String) {
        this.presenter.updateCheckedTask(id, context!!)
    }

    override fun onDeleteImageButtonClicked(id: String) {
        presenter.deleteTask(id, context!!)
    }

    override fun onShareImageButtonClicked(id: String) {
        presenter.shareTask(id, context!!)
    }

    companion object {
        val CREATE_TASK_RC = 56
        val UPDATE_TASK_RC = 67
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CREATE_TASK_RC -> {
                if (resultCode == Activity.RESULT_OK) {
                    var taskGson = data?.getStringExtra("task")
                    var task = Gson().fromJson(taskGson, Task::class.java)

                    var adapter = taskRecyclerView.adapter as DashboardRecyclerViewAdapter
                    adapter.addTask(task)
                }
            }

            UPDATE_TASK_RC -> {

            }
        }
    }


}