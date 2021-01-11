package com.ubaifadhli.mintasks.ui.login

import android.content.Intent
import android.os.Bundle
import com.ubaifadhli.mintasks.ui.base.BaseActivity
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.dashboard.DashboardActivity
import com.ubaifadhli.mintasks.utils.UserSharedPreferencesManager

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Login")

        var token = UserSharedPreferencesManager(this).getToken()

        if (token!!.isNotEmpty()) {
            redirectToDashboard()
        } else {
            setCurrentFragment(LoginFragment())
        }
    }

    fun redirectToDashboard() {
        var intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}