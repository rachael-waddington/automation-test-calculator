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

    fun longClick(id: Int) {
        onView(withId(id)).perform(longClick())
    }

    fun matchesWithText(id: Int, text: String) {
        onView(withId(id)).check(matches(withText(text)))
    }

    fun matchesWithNoText(id: Int) {
        onView(withId(id)).check(matches(withText("")))
    }

    class InvalidPageException(message: String) : RuntimeException(message)
}

