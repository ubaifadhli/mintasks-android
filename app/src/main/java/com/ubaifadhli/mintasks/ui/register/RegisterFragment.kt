package com.ubaifadhli.mintasks.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.base.BaseFragment
import com.ubaifadhli.mintasks.ui.login.LoginActivity
import com.ubaifadhli.mintasks.ui.login.LoginPresenter

class RegisterFragment : BaseFragment(R.layout.fragment_register), RegisterContract.RegisterView {
    lateinit var registerButton : Button
    lateinit var loginButton: Button
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmPasswordEditText: EditText

    lateinit var presenter : RegisterPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerButton = view.findViewById(R.id.register_register_button)
        loginButton = view.findViewById(R.id.register_login_button)
        nameEditText = view.findViewById(R.id.register_name_edittext)
        emailEditText = view.findViewById(R.id.register_email_edittext)
        passwordEditText = view.findViewById(R.id.register_password_edittext)
        confirmPasswordEditText = view.findViewById(R.id.register_confirm_password_edittext)

        registerButton.setOnClickListener { onRegisterButtonClicked() }

        loginButton.setOnClickListener { navigateToActivity(LoginActivity()) }

        setPresenter(RegisterPresenter(this))
    }

    override fun onRegisterButtonClicked() {
        var name = nameEditText.text.toString()
        var email = emailEditText.text.toString()
        var password = passwordEditText.text.toString()
        var confirmPassword = confirmPasswordEditText.text.toString()

        if (password == confirmPassword) presenter.attemptRegister(name, email, password) else showToast("Please double-check your password.")
    }

    override fun navigateToActivity(activity: Activity) {
        var intent = Intent(getActivity(), activity::class.java)
        startActivity(intent)
    }

    override fun setPresenter(presenter: RegisterContract.RegisterPresenter) {
        this.presenter = presenter as RegisterPresenter
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}