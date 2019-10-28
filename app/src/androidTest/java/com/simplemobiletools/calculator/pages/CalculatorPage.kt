package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.helpers.Operator
import com.simplemobiletools.calculator.helpers.Operator.*

class CalculatorPage : BasePage(R.id.calculator_holder) {

    private val numberBtns = arrayOf(R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9)
    private val plusBtn = R.id.btn_plus
    private val minusBtn = R.id.btn_minus
    private val divideBtn = R.id.btn_divide
    private val multiplyBtn = R.id.btn_multiply
    private val equalsBtn = R.id.btn_equals
    private val decimalBtn = R.id.btn_decimal
    private val powerBtn = R.id.btn_power
    private val moduloBtn = R.id.btn_percent
    private val rootBtn = R.id.btn_root
    private val clearBtn = R.id.btn_clear
    private val result = R.id.result
    private val formula = R.id.formula

    private var initialNumberEntered = false

    fun assertResultIs(expectedResult: String) = apply {
        matchesWithText(result, expectedResult)
    }

    fun assertFormulaIs(expectedFormula: String) = apply {
        matchesWithText(formula, expectedFormula)
    }

    fun assertFormulaIsEmpty() = apply {
        matchesWithNoText(formula)
    }

    fun assertActionBarTextIsCorrect() = apply {
        ActionBar().actionBarMatchesWithText("Calculator_debug")
    }

    fun clearSingleDigit() = apply {
        click(clearBtn)
    }

    fun clearAll() = apply {
        longClick(clearBtn)
    }

    fun manipulateNumbers(numbers: ArrayList<Double>, operator: Operator) = apply {
        for (value in numbers) {
            // Don't add operator until a number has already been entered
            // Special case: ROOT only has one number so must be handled later
            if (!initialNumberEntered && operator != ROOT) {
                enterNumber(value)
                // Initial value has now been entered
                initialNumberEntered = true
            } else {
                // Now operators can be added
                enterNumberAndOperator(value, operator)
            }
        }
        click(equalsBtn)
    }

    // Enter a single operator and number
    private fun enterNumberAndOperator(number: Double, operator: Operator) {
        when (operator) {
            ADD -> click(plusBtn)
            MINUS -> click(minusBtn)
            DIVIDE -> click(divideBtn)
            MULTIPLY -> click(multiplyBtn)
            POWER -> click(powerBtn)
            MODULO -> click(moduloBtn)
        }
        enterNumber(number)
        // Special case: ROOT must be entered after number
        when (operator) {
            ROOT -> click(rootBtn)
        }
    }

    fun enterNumber(number: Double) = apply {
        // Convert to string array to isolate decimal point or minus and enter one by one
        val digits = number.toString().map { it.toString() }
        for (digit in digits) {
            when (digit) {
                "." -> click(decimalBtn)
                "-" -> click(minusBtn)
                else -> click(numberBtns[digit.toInt()])
            }
        }
    }
}