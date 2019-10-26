package com.simplemobiletools.calculator

import android.support.test.rule.ActivityTestRule
import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.pages.CalculatorPage
import org.junit.After
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun canAddDigits() {
        CalculatorPage().addDigits(arrayListOf(1, 2, 3))
                .assertResultIs(6)
                .assertFormulaIs("3+3")
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }
}