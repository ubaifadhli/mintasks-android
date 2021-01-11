package com.ubaifadhli.mintasks.ui.dashboard

import android.content.Context
import android.content.Intent
import com.ubaifadhli.mintasks.data.model.LoginResponse
import com.ubaifadhli.mintasks.data.model.Task
import com.ubaifadhli.mintasks.data.model.TaskResponse
import com.ubaifadhli.mintasks.data.model.TasksResponse
import com.ubaifadhli.mintasks.data.network.APIService
import com.ubaifadhli.mintasks.data.network.RetrofitClient
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardPresenter (var view : DashboardContract.DashboardView?) : DashboardContract.DashboardPresenter {
    override fun getTasks(context: Context) {
        var token = UserSharedPreferencesManager(context).getToken()!!

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.getTasks(token)

        call.enqueue(object : Callback<TasksResponse> {
            override fun onResponse(call: Call<TasksResponse>, response: Response<TasksResponse>) {
                if(response.isSuccessful) {
                    var tasks = response.body()?.tasks as ArrayList<Task>

                    view?.setRecyclerViewAdapter(tasks)
                }
            }
            override fun onFailure(call: Call<TasksResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun updateCheckedTask(id: String, context: Context) {
        var token = UserSharedPreferencesManager(context).getToken()

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.updateTaskChecked(id, token!!)

        call.enqueue(object : Callback<TaskResponse> {
            override fun onResponse(call: Call<TaskResponse>, response: Response<TaskResponse>) {
                if(response.isSuccessful) {
                    view?.showToast("Task has been updated.")
                }
            }
            override fun onFailure(call: Call<TaskResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun deleteTask(id: String, context: Context) {
        var token = UserSharedPreferencesManager(context).getToken()

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.deleteTask(id, token!!)

        call.enqueue(object : Callback<TaskResponse> {
            override fun onResponse(call: Call<TaskResponse>, response: Response<TaskResponse>) {
                if(response.isSuccessful) {
                    view?.showToast("Task has been deleted.")
                }
            }
            override fun onFailure(call: Call<TaskResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun shareTask(id: String, context: Context) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "You have been invited to collaborate in this task. please visit " + API_URL + id)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }

    override fun onDestroy() {
        this.view = null
    }

    companion object {
        val API_URL = "http://chizu.site/api/task/"
    }
}