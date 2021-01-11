package com.ubaifadhli.mintasks.ui.taskcreateupdate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.ui.base.BaseFragment
import com.ubaifadhli.mintasks.ui.dashboard.DashboardPresenter

class CreateTaskFragment : BaseFragment(R.layout.fragment_taskcreateupdate), CreateTaskContract.CreateTaskView {
    lateinit var nameEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var dueDateEditText: EditText
    lateinit var saveButton: Button

    lateinit var presenter : CreateTaskPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.cu_task_name_edittext)
        descriptionEditText = view.findViewById(R.id.cu_task_description_edittext)
        dueDateEditText = view.findViewById(R.id.cu_task_due_date_edittext)
        saveButton = view.findViewById(R.id.cu_save_update_button)

        saveButton.text = getString(R.string.save)

        saveButton.setOnClickListener { onSaveButtonClicked() }

        setPresenter(CreateTaskPresenter(this))

        hideUnnecessaryWidgets(view)
    }

    override fun onSaveButtonClicked() {
        var name = nameEditText.text.toString()
        var description = descriptionEditText.text.toString()
        var dueDate = dueDateEditText.toString()

        presenter.createTask(name, description, dueDate, context!!)
    }

    override fun returnToDashboard(task : Task) {
        var resultIntent = Intent()
        resultIntent.putExtra("taskGson", Gson().toJson(task))
        activity?.setResult(Activity.RESULT_OK, resultIntent)
        activity?.finish()
    }

    override fun hideUnnecessaryWidgets(view: View) {
        var ownerCheckBox = view.findViewById(R.id.cu_task_owner_checkbox) as CheckBox
        var collaboratorCheckBox = view.findViewById(R.id.cu_task_collaborator_checkbox) as CheckBox

        ownerCheckBox.visibility = View.INVISIBLE
        collaboratorCheckBox.visibility = View.INVISIBLE
    }

    override fun navigateToActivity(activity: Activity) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: CreateTaskContract.CreateTaskPresenter) {
        this.presenter = presenter as CreateTaskPresenter
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
    }
}