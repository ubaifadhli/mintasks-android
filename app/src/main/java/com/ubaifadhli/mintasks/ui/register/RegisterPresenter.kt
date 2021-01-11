package com.ubaifadhli.mintasks.ui.register

import com.ubaifadhli.mintasks.data.model.LoginResponse
import com.ubaifadhli.mintasks.data.model.RegisterResponse
import com.ubaifadhli.mintasks.data.model.User
import com.ubaifadhli.mintasks.data.network.APIService
import com.ubaifadhli.mintasks.data.network.RetrofitClient
import com.ubaifadhli.mintasks.ui.dashboard.DashboardActivity
import com.ubaifadhli.mintasks.ui.login.LoginActivity
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Handler

class RegisterPresenter(var view : RegisterContract.RegisterView?) : RegisterContract.RegisterPresenter {

    override fun attemptRegister(name: String, email: String, password: String) {
        var user = User()
        user.name = name
        user.email = email
        user.password = password
        user.passwordConfirmation = password

        var request = RetrofitClient.buildService(APIService::class.java)
        var call = request.register(user)

        call.enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if(response.isSuccessful) {
                    var loginResponse = response.body()

                    view?.showToast("Account has been successfully created.")

                    Thread.sleep(1500)

                    view?.navigateToActivity(LoginActivity())

                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                view?.showToast(t.message.toString())
            }
        })
    }

    override fun onDestroy() {
        this.view = null
    }
}