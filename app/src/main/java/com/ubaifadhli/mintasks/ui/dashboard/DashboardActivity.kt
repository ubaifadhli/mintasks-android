package com.ubaifadhli.mintasks.ui.dashboard

import android.os.Bundle
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.base.BaseActivity

class DashboardActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Dashboard")

        setCurrentFragment(DashboardFragment())
    }
}