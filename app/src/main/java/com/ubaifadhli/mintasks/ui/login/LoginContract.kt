package com.ubaifadhli.mintasks.ui.login

import android.content.Context
import com.ubaifadhli.mintasks.ui.base.BasePresenter
import com.ubaifadhli.mintasks.ui.base.BaseView

interface LoginContract {
    interface LoginPresenter : BasePresenter<LoginView> {
        fun attemptLogin (email : String, password : String, context: Context)
    }

    interface LoginView : BaseView<LoginPresenter> {
        fun onLoginButtonClicked()
    }
}