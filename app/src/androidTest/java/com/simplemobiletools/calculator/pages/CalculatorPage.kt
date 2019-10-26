package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R

class CalculatorPage : BasePage(R.id.calculator_holder) {

    private var numberBtns = arrayOf(R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9)
    private var plusBtn = R.id.btn_plus
    private var minusBtn = R.id.btn_minus
    private var divideBtn = R.id.btn_divide
    private var multiplyBtn = R.id.btn_multiply
    private var equalsBtn = R.id.btn_equals
    private var decimalBtn = R.id.btn_decimal
    private var powerBtn = R.id.btn_power
    private var moduloBtn = R.id.btn_percent
    private var rootBtn = R.id.btn_root
    private var result = R.id.result
    private var formula = R.id.formula

    private var initialNumberEntered = false

    fun assertResultIs(expectedResult: String) = apply {
        matchesWithText(result, expectedResult)
    }

    fun assertFormulaIs(expectedFormula: String) = apply {
        matchesWithText(formula, expectedFormula)
    }

    fun manipulateNumbers(numbers: ArrayList<Double>, modifier: Char) = apply {
        for (value in numbers) {
            // Don't add modifier until a number has already been entered
            if (!initialNumberEntered) {
                enterNumber(value)
                // Initial value has now been entered
                initialNumberEntered = true
            } else {
                manipulateNumber(value, modifier)
            }
        }
        click(equalsBtn)
    }

    private fun manipulateNumber(number: Double, modifier: Char) = apply {
        when (modifier) {
            '+' -> click(plusBtn)
            '-' -> click(minusBtn)
            '/' -> click(divideBtn)
            '*' -> click(multiplyBtn)
            '^' -> click(powerBtn)
            '%' -> click(moduloBtn)
            '√' -> click(rootBtn)
        }
        enterNumber(number)
    }


    private fun enterNumber(number: Double) {
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