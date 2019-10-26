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
    fun canAddNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(1.0, 2.0, 3.0), '+')
                .assertResultIs("6")
                .assertFormulaIs("3+3")
    }

    @Test
    fun canSubtractNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(9.4, 5.6, 4.1), '-')
                .assertResultIs("-0.3")
                .assertFormulaIs("3.8-4.1")
    }

    @Test
    fun canDivideNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(28.0, 7.0, 2.0, 1.0), '/')
                .assertResultIs("2")
                .assertFormulaIs("2/1")
    }

    @Test
    fun canMultiplyNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(6.0, 8.0, 10.0, 2.0), '*')
                .assertResultIs("960")
                .assertFormulaIs("480*2")
    }

    @Test
    fun canPowerNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(8.0, 5.0), '^')
                .assertResultIs("32,768")
                .assertFormulaIs("8^5")
    }

    @Test
    fun canModuloNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(23.0, 12.0), '%')
                .assertResultIs("11")
                .assertFormulaIs("23%12")
    }

    @Test
    fun canRootNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(9.0), '√')
                .assertResultIs("3")
                .assertFormulaIs("√9")
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }
}