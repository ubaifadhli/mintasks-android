package com.ubaifadhli.mintasks.ui.register

import android.os.Bundle
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.base.BaseActivity

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Register")

        setCurrentFragment(RegisterFragment())
    }
}