package com.ubaifadhli.mintasks.ui.base

import android.app.Activity

interface BaseView<T> {
    fun navigateToActivity (activity: Activity)
    fun setPresenter (presenter : T)
    fun onDestroy ()
    fun showToast (message : String)
}