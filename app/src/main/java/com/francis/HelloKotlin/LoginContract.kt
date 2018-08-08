package com.francis.HelloKotlin

interface LoginContract {
    interface View {
        fun getUsername() : String
        fun getPassword(): String
        fun showEmptyUserNameErrorMessage()
        fun showEmptyPasswordErrorMessage()
        fun showAuthenticationSucceed()
        fun showInvalidPassword()
    }

    interface Presenter {
        fun SigninButtonClick()
    }
}