package com.ubaifadhli.mintasks.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ubaifadhli.mintasks.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_frame, fragment)
                .commit()
    }
}