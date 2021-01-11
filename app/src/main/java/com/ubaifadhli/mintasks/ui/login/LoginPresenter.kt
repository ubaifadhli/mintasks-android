package com.ubaifadhli.mintasks.ui.login

import android.content.Context
import com.ubaifadhli.mintasks.data.model.LoginResponse
import com.ubaifadhli.mintasks.data.model.User
import com.ubaifadhli.mintasks.data.network.APIService
import com.ubaifadhli.mintasks.data.network.RetrofitClient
import com.ubaifadhli.mintasks.ui.dashboard.DashboardActivity
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(var view : LoginContract.LoginView?) : LoginContract.LoginPresenter {
    override fun attemptLogin(email: String, password: String, context: Context) {
        var user = User()
        user.email = email
        user.password = password

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.login(user)

        call.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful) {
                    var loginResponse = response.body()
                    var token = loginResponse?.token

                    var manager = UserSharedPreferencesManager(context)

                    manager.setToken("Bearer " + token)

                    view?.navigateToActivity(DashboardActivity())

                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun onDestroy() {
        this.view = null
    }
}