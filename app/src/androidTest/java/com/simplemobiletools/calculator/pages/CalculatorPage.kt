package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R

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
    private val result = R.id.result
    private val formula = R.id.formula
    private val clearBtn = R.id.btn_clear

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

    fun manipulateNumbers(numbers: ArrayList<Double>, operator: Char) = apply {
        for (value in numbers) {
            // Don't add operator until a number has already been entered
            // Special case: '√' only has one number so must be handled later
            if (!initialNumberEntered && operator != '√') {
                enterNumber(value)
                // Initial value has now been entered
                initialNumberEntered = true
            } else {
                // Now operators can be added
                manipulateNumber(value, operator)
            }
        }
        click(equalsBtn)
    }

    private fun manipulateNumber(number: Double, operator: Char) {
        when (operator) {
            '+' -> click(plusBtn)
            '-' -> click(minusBtn)
            '/' -> click(divideBtn)
            '*' -> click(multiplyBtn)
            '^' -> click(powerBtn)
            '%' -> click(moduloBtn)
        }
        enterNumber(number)
        // Special case: '√' must be entered after number
        when (operator) {
            '√' -> click(rootBtn)
        }
    }

    fun enterNumber(number: Double) = apply {
        // Convert to string array to isolate decimal point and enter one by one
        val digits = number.toString().map { it.toString() }
        for (digit in digits) {
            if (digit == ".") {
                click(decimalBtn)
            }
            else {
                click(numberBtns[digit.toInt()])
            }
        }
    }
}