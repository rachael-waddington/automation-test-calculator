package com.simplemobiletools.calculator

import android.support.test.rule.ActivityTestRule
import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.pages.AboutPage
import com.simplemobiletools.calculator.pages.ActionBar
import org.junit.After
import org.junit.Rule
import org.junit.Test

class AboutTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun doesHaveCorrectActionBar() {
        ActionBar().goToAbout()
        AboutPage().assertActionBarTextIsCorrect()
        AboutPage().goBackToCalculator()

    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }
}