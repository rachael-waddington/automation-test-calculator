package com.simplemobiletools.calculator.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId

open class BasePage(resourceIdName: Int) {

    init {
        onView(withId(resourceIdName)).check(
                ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun <T : BasePage> `is`(type: Class<T>): T {
        if (type.isInstance(this)) {
            return type.cast(this)
        } else {
            throw InvalidPageException(
                    "Invalid page type. Expected: " + type.simpleName + ", but got: " + this.javaClass.simpleName)
        }
    }

    fun click(id: Int) {
        onView(withId(id)).perform(click())
    }

    fun matchesWithText(id: Int, text: String) {
        onView(withId(id)).check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

    class InvalidPageException(message: String) : RuntimeException(message)
}

