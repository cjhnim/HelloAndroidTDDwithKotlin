package com.francis.HelloKotlin

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule @JvmField val activity =
            ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.francis.HelloKotlin", appContext.packageName)
    }

    @Test
    fun showEmptyUserIdErrorMessage() {
        //Arrange
        onView(withId(R.id.username)).perform(typeText(""))
        //Act
        onView(withId(R.id.signin)).perform(click())
        //Assert
        onView(withId(R.id.info))
                .check(matches(withText(R.string.empty_userid)))
    }

    @Test
    fun showEmptyPasswordErrorMessage() {
        //Arrange
        onView(withId(R.id.username)).perform(typeText("cjhnim"))
        //Act
        onView(withId(R.id.signin)).perform(click())
        //Assert
        onView(withId(R.id.info))
                .check(matches(withText(R.string.empty_password)))
    }

    @Test
    fun showInvalidPasswordErrorMessage() {
        //Arrange
        onView(withId(R.id.username)).perform(typeText("cjhnim"))
        onView(withId(R.id.password)).perform(typeText("1234"))
        //Act
        onView(withId(R.id.signin)).perform(click())
        //Assert
        onView(withId(R.id.info))
                .check(matches(withText(R.string.invalid_password)))
    }

    @Test
    fun showPassAuthentication() {
        //Arrange
        onView(withId(R.id.username)).perform(typeText("cjhnim"))
        onView(withId(R.id.password)).perform(typeText("1111"))
        //Act
        onView(withId(R.id.signin)).perform(click())
        //Assert
        onView(withId(R.id.info))
                .check(matches(withText(R.string.signin_succeed)))
    }

}
