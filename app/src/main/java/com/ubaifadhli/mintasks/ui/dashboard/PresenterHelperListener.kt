package com.ubaifadhli.mintasks.ui.dashboard

interface PresenterHelperListener {
    fun navigateToDetailActivity(id : String)
    fun onCheckboxClicked(id : String)
    fun onDeleteImageButtonClicked(id : String)
    fun onShareImageButtonClicked(id : String)
}