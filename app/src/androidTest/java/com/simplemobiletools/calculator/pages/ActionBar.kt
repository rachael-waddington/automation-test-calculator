package com.simplemobiletools.calculator.pages

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import com.simplemobiletools.calculator.R

class ActionBar : BasePage(R.id.action_bar) {

    fun actionBarMatchesWithText(text: String) {
        matchesTextViewWithText("action_bar", text)
    }

    fun goToSettings() {
        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().context)
        click("Settings")
    }

    fun goToAbout() {
        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().context)
        click("About")
    }

    fun clickBack() {
        clickItemWithContentDescription("Navigate up")
    }
}