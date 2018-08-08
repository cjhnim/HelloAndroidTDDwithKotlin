package com.francis.HelloKotlin

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class LoginPresenterTest {
    private lateinit var mView : LoginContract.View
    private lateinit var mLogin : Login
    private lateinit var mPresenter : LoginPresenter

    @Before
    fun setUp() {
        mView = Mockito.mock(LoginContract.View::class.java)
        mLogin = Mockito.mock(Login::class.java)
        mPresenter = LoginPresenter(mView, mLogin)
    }

    @Test
    fun showEmptyUserNameErrorMessage() {
        Mockito.`when`(mView.getUsername()).thenReturn("")
        mPresenter.SigninButtonClick()
        Mockito.`verify`(mView).showEmptyUserNameErrorMessage()
    }

    @Test
    fun showEmptyPasswordErrorMessage() {
        Mockito.`when`(mView.getUsername()).thenReturn("cjhnim")
        Mockito.`when`(mView.getPassword()).thenReturn("")
        mPresenter.SigninButtonClick()
        Mockito.`verify`(mView).showEmptyPasswordErrorMessage()
    }

    @Test
    fun showInvalidPasswordErrorMessage() {
        var id : String= "cjhnim"
        var password : String= "1234"
        Mockito.`when`(mView.getUsername()).thenReturn(id)
        Mockito.`when`(mView.getPassword()).thenReturn(password)
        Mockito.`when`(mLogin.authenticate(id, password)).thenReturn(false)
        mPresenter.SigninButtonClick()
        Mockito.`verify`(mView).showInvalidPassword()
    }

    @Test
    fun showLoginSucceedMessage() {
        var id : String= "cjhnim"
        var password : String= "1111"
        Mockito.`when`(mView.getUsername()).thenReturn(id)
        Mockito.`when`(mView.getPassword()).thenReturn(password)
        Mockito.`when`(mLogin.authenticate(id, password)).thenReturn(true)
        mPresenter.SigninButtonClick()
        Mockito.`verify`(mView).showAuthenticationSucceed()
    }
}