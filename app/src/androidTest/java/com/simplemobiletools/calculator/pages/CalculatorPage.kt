package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R

class CalculatorPage : BasePage(R.id.calculator_holder) {

    private var numberBtns = arrayOf(R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9)
    private var plusBtn = R.id.btn_plus
    private var equalsBtn = R.id.btn_equals
    private var result = R.id.result
    private var formula = R.id.formula


    fun addDigits(digits: ArrayList<Int>) = apply {
        for(x in digits) {
            when (x) {
                0 ->  click(numberBtns[0])
                1 ->  click(numberBtns[1])
                2 ->  click(numberBtns[2])
                3 ->  click(numberBtns[3])
                4 ->  click(numberBtns[4])
                5 ->  click(numberBtns[5])
                6 ->  click(numberBtns[6])
                7 ->  click(numberBtns[7])
                8 ->  click(numberBtns[8])
                9 ->  click(numberBtns[9])
            }
         click(plusBtn)
        }
        click(equalsBtn)
    }

    fun assertResultIs(expectedResult: Int) = apply {
        matchesWithText(result, expectedResult.toString())
    }

    fun assertFormulaIs(expectedFormula: String) = apply {
        matchesWithText(formula, expectedFormula)
    }
}