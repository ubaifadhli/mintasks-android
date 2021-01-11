package com.ubaifadhli.mintasks.ui.taskcreateupdate

import android.content.Context
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.data.model.TaskResponse
import com.ubaifadhli.mintasks.data.network.APIService
import com.ubaifadhli.mintasks.data.network.RetrofitClient
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateTaskPresenter(var view : CreateTaskContract.CreateTaskView?) : CreateTaskContract.CreateTaskPresenter {
    override fun createTask(name : String, description : String, dueDate : String, context: Context) {
        var token = UserSharedPreferencesManager(context).getToken()

        var task = Task()
        task.name = name
        task.description = description
        task.dueDate = dueDate

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.createTask(token!!, task)

        call.enqueue(object : Callback<TaskResponse> {
            override fun onResponse(call: Call<TaskResponse>, response: Response<TaskResponse>) {
                if(response.isSuccessful) {
                    var task = response.body()?.task

                    view?.showToast("Task has been created.")
                    view?.returnToDashboard(task!!)
                }
            }
            override fun onFailure(call: Call<TaskResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}