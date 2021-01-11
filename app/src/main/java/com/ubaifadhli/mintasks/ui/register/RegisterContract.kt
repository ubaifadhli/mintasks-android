package com.ubaifadhli.mintasks.ui.register

import com.ubaifadhli.mintasks.ui.base.BasePresenter
import com.ubaifadhli.mintasks.ui.base.BaseView

interface RegisterContract {
    interface RegisterPresenter : BasePresenter<RegisterView> {
        fun attemptRegister(name : String, email : String, password : String)
    }

    interface RegisterView : BaseView<RegisterPresenter> {
        fun onRegisterButtonClicked()
    }
}