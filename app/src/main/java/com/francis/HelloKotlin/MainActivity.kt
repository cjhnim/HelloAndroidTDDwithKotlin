package com.francis.HelloKotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), LoginContract.View {

    override fun getUsername(): String {
        return username.text.toString()
    }

    override fun getPassword(): String {
        return password.text.toString()
    }

    override fun showEmptyPasswordErrorMessage() {
        info.setText(R.string.empty_password)
    }

    override fun showAuthenticationSucceed() {
        info.setText(R.string.signin_succeed)
    }

    override fun showInvalidPassword() {
        info.setText(R.string.invalid_password)
    }

    override fun showEmptyUserNameErrorMessage() {
        info.setText(R.string.empty_userid)
    }

    private val signinButton: Button by lazy {
        val button: Button = findViewById(R.id.signin)
        button
    }

    private val info: TextView by lazy {
        val textView: TextView = findViewById(R.id.info)
        textView
    }

    private val username: EditText by lazy {
        val editText: EditText = findViewById(R.id.username)
        editText
    }

    private val password: EditText by lazy {
        val editText: EditText = findViewById(R.id.password)
        editText
    }

    private val mLogin: Login by lazy {
        val login: Login = Login()
        login
    }

    private val mLoginPresenter: LoginPresenter by lazy {
        val presenter = LoginPresenter(this, mLogin)
        presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signinButton.setOnClickListener {
            mLoginPresenter.SigninButtonClick()
        }
    }
}
