package com.simplemobiletools.calculator.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*

open class BasePage(resourceIdName: Int) {

    init {
        onView(withId(resourceIdName)).check(matches(isDisplayed()))
    }

    protected fun click(id: Int) {
        onView(withId(id)).perform(click())
    }

    protected fun longClick(id: Int) {
        onView(withId(id)).perform(longClick())
    }

    protected fun matchesWithText(id: Int, text: String) {
        onView(withId(id)).check(matches(withText(text)))
    }

    protected fun matchesWithNoText(id: Int) {
        onView(withId(id)).check(matches(withText("")))
    }

}

