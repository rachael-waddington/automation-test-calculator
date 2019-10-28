package com.simplemobiletools.calculator.pages

import com.simplemobiletools.calculator.R

class SettingsPage : BasePage(R.id.settings_holder) {

    fun assertActionBarTextIsCorrect() = apply {
        ActionBar().actionBarMatchesWithText("Settings")
    }
}