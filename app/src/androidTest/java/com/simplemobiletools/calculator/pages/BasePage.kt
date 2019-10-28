package com.simplemobiletools.calculator.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.TextView
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf

open class BasePage(resourceIdName: Int) {

    init {
        // Check the correct page is displayed
        onView(withId(resourceIdName)).check(matches(isDisplayed()))
    }

    protected fun click(id: Int) {
        onView(withId(id)).perform(click())
    }

    protected fun click(text: String) {
        onView(withText(text)).perform(click())
    }

    protected fun longClick(id: Int) {
        onView(withId(id)).perform(longClick())
    }

    protected fun clickItemWithContentDescription(contentDesc: String) {
        onView(withContentDescription(contentDesc)).perform(click());
    }

    protected fun matchesWithText(id: Int, text: String) {
        onView(withId(id)).check(matches(withText(text)))
    }

    protected fun matchesWithNoText(id: Int) {
        onView(withId(id)).check(matches(withText("")))
    }

    protected fun matchesTextViewWithText(resourceName: String, text: String) {
        onView(allOf(instanceOf(TextView::class.java),
                withParent(withResourceName(resourceName))))
                .check(matches(withText(text)))
    }
}

