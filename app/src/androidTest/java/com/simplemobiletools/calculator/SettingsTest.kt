package com.simplemobiletools.calculator

import android.support.test.rule.ActivityTestRule
import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.pages.ActionBar
import com.simplemobiletools.calculator.pages.SettingsPage
import org.junit.After
import org.junit.Rule
import org.junit.Test

class SettingsTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun doesHaveCorrectActionBar() {
        ActionBar().goToSettings()
        SettingsPage().assertActionBarTextIsCorrect()
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }
}