package com.ubaifadhli.mintasks.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ubaifadhli.mintasks.ui.base.BaseFragment
import com.ubaifadhli.mintasks.R
import com.ubaifadhli.mintasks.ui.register.RegisterActivity

class LoginFragment : BaseFragment(R.layout.fragment_login), LoginContract.LoginView {
    lateinit var registerButton : Button
    lateinit var loginButton: Button
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText

    lateinit var presenter: LoginPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerButton = view.findViewById(R.id.login_register_button)
        loginButton = view.findViewById(R.id.login_login_button)
        emailEditText = view.findViewById(R.id.login_email_edittext)
        passwordEditText = view.findViewById(R.id.login_password_edittext)

        registerButton.setOnClickListener { navigateToActivity(RegisterActivity()) }

        loginButton.setOnClickListener { onLoginButtonClicked() }

        setPresenter(LoginPresenter(this))
    }

    override fun navigateToActivity(activity: Activity) {
        var intent = Intent(getActivity(), activity::class.java)
        startActivity(intent)
    }

    override fun onLoginButtonClicked() {
        var email = emailEditText.text.toString()
        var password = passwordEditText.text.toString()

        presenter.attemptLogin(email, password, context!!)
    }

    override fun setPresenter(presenter: LoginContract.LoginPresenter) {
        this.presenter = presenter as LoginPresenter
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}