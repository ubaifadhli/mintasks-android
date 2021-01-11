package com.ubaifadhli.mintasks.ui.dashboard

import android.content.Context
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.ui.base.BasePresenter
import com.ubaifadhli.mintasks.ui.base.BaseView

interface DashboardContract {
    interface DashboardPresenter : BasePresenter<DashboardView> {
        fun getTasks(context: Context)
        fun updateCheckedTask(id : String, context: Context)
        fun deleteTask(id : String, context: Context)
        fun shareTask(id : String, context: Context)
    }

    interface DashboardView : BaseView<DashboardPresenter> {
        fun setRecyclerViewAdapter(tasks : ArrayList<Task>)
        fun onAddTaskFABClicked()
    }
}