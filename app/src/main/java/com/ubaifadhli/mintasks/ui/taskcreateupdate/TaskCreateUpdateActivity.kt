package com.ubaifadhli.mintasks.ui.taskcreateupdate

import android.os.Bundle
import android.util.Log
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.base.BaseActivity
import com.ubaifadhli.mintasks.ui.dashboard.DashboardFragment

class TaskCreateUpdateActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var requestCode = getIntent().getIntExtra("requestCode", 0)

        Log.e("HEHE", "onCreate: " + requestCode, null)

        if (requestCode == CREATE_TASK_RC) {
            setTitle("Create Task")
            setCurrentFragment(CreateTaskFragment())

        } else if (requestCode == UPDATE_TASK_RC){
            setTitle("Update Task")
            setCurrentFragment(UpdateTaskFragment())
        }

    }

    companion object {
        val CREATE_TASK_RC = 56
        val UPDATE_TASK_RC = 67
    }
}