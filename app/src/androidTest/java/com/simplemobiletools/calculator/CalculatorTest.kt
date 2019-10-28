package com.simplemobiletools.calculator

import android.support.test.rule.ActivityTestRule
import com.simplemobiletools.calculator.activities.MainActivity
import com.simplemobiletools.calculator.helpers.Operator.*
import com.simplemobiletools.calculator.pages.CalculatorPage
import org.junit.After
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun canAddNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(1.0, 2.0, 3.0), ADD)
                .assertResultIs("6")
                .assertFormulaIs("3+3")
    }

    @Test
    fun canSubtractNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(9.4, 5.6, 4.1), MINUS)
                .assertResultIs("-0.3")
                .assertFormulaIs("3.8-4.1")
    }

    @Test
    fun canDivideNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(28.0, 7.0, 2.0, 1.0), DIVIDE)
                .assertResultIs("2")
                .assertFormulaIs("2/1")
    }

    @Test
    fun canMultiplyNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(6.0, 8.0, 10.0, 2.0), MULTIPLY)
                .assertResultIs("960")
                .assertFormulaIs("480*2")
    }

    @Test
    fun canPowerNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(8.0, 5.0), POWER)
                .assertResultIs("32,768")
                .assertFormulaIs("8^5")
    }

    @Test
    fun canModuloNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(23.0, 12.0), MODULO)
                .assertResultIs("11")
                .assertFormulaIs("23%12")
    }

    @Test
    fun canRootNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(9.0), ROOT)
                .assertResultIs("3")
                .assertFormulaIs("√9")
    }

    @Test
    fun canUseMultipleOperators() {
        CalculatorPage().manipulateNumbers(arrayListOf(6.0, 7.5), ADD)
                .manipulateNumbers(arrayListOf(2.0, 0.5), MINUS)
                .assertResultIs("11")
                .assertFormulaIs("11.5-0.5")
                .manipulateNumbers(arrayListOf(0.0),POWER)
                .assertResultIs("1")
                .assertFormulaIs("11^0")
                .manipulateNumbers(arrayListOf(33.0, 2.0, 2.0), MULTIPLY)
                .assertResultIs("132")
                .assertFormulaIs("66*2")
                .manipulateNumbers(arrayListOf(5.0), DIVIDE)
                .assertResultIs("26.4")
                .assertFormulaIs("132/5")
    }

    @Test
    fun canEnterLargeNumbers() {
        CalculatorPage().enterNumber(33333333333333333333.0)
                .assertResultIs("33333333333333333333.0")
    }

    @Test
    fun canParseImaginaryNumbers() {
        CalculatorPage().manipulateNumbers(arrayListOf(-1.0), ROOT)
                .assertResultIs("NaN")
    }

    @Test
    fun canClearDigit() {
        CalculatorPage().enterNumber(.321)
                .assertResultIs("0.321")
                .clearSingleDigit()
                .assertResultIs("0.32")
                .clearSingleDigit()
                .clearSingleDigit()
                .assertResultIs("0")
                .assertFormulaIsEmpty()
    }

    @Test
    fun canClearAll() {
        CalculatorPage().manipulateNumbers(arrayListOf(8.0, 9.0), MINUS)
                .assertResultIs("-1")
                .assertFormulaIs("8-9")
                .clearAll()
                .assertResultIs("0")
                .assertFormulaIsEmpty()
    }

    @Test
    fun doesHaveCorrectActionBar() {
        CalculatorPage().assertActionBarTextIsCorrect()
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }
}