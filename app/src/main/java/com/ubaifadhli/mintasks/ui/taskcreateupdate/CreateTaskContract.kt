package com.ubaifadhli.mintasks.ui.taskcreateupdate

import android.content.Context
import android.view.View
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.ui.base.BasePresenter
import com.ubaifadhli.mintasks.ui.base.BaseView

interface CreateTaskContract {
    interface CreateTaskPresenter : BasePresenter<CreateTaskView> {
        fun createTask(name : String, description : String, dueDate : String, context: Context)
    }

    interface CreateTaskView : BaseView<CreateTaskPresenter> {
        fun onSaveButtonClicked()
        fun returnToDashboard(task : Task)
        fun hideUnnecessaryWidgets(view : View)
    }
}