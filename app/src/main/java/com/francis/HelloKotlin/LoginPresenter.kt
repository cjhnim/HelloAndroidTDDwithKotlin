package com.francis.HelloKotlin

open class LoginPresenter(var mView: LoginContract.View, var mLogin: Login) : LoginContract.Presenter {

    override fun SigninButtonClick() {

        if (mView.getUsername().isEmpty()) {
            mView.showEmptyUserNameErrorMessage()
            return
        }

        if(mView.getPassword().isEmpty()) {
            mView.showEmptyPasswordErrorMessage()
            return
        }

        if(mLogin.authenticate(mView.getUsername(), mView.getPassword())) {
            mView.showAuthenticationSucceed()
        } else {
            mView.showInvalidPassword()
        }
    }
}