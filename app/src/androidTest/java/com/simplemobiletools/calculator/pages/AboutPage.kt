package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R

class AboutPage : BasePage(R.id.about_holder) {

    fun assertActionBarTextIsCorrect() = apply {
        ActionBar().actionBarMatchesWithText("About")
    }

    fun goBackToCalculator() = apply {
        ActionBar().clickBack()
        // Init to ensure on right page
        CalculatorPage()
    }
}