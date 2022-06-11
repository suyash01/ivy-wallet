package com.ivy.wallet.compose.helpers

import androidx.compose.ui.test.*
import com.ivy.wallet.compose.IvyComposeTestRule

class PlannedPaymentsScreen(
    private val composeTestRule: IvyComposeTestRule
) {

    fun clickAddPlannedPayment() {
        composeTestRule.onNodeWithText("Add payment")
            .performClick()
    }

    fun clickPlannedPayment(
        amount: String
    ) {
        composeTestRule.onNode(
            hasTestTag("planned_payment_card")
                .and(hasAnyDescendant(hasText(amount))),
            useUnmergedTree = true
        )
            .performScrollTo()
            .performClick()
    }

    fun assertPlannedPaymentDoesNotExist(
        amount: String
    ) {
        composeTestRule.onNode(
            hasTestTag("planned_payment_card")
                .and(hasAnyDescendant(hasText(amount))),
            useUnmergedTree = true
        ).assertDoesNotExist()
    }

    fun assertUpcomingExpense(
        amount: String,
        currency: String
    ) {
        composeTestRule.onNodeWithTag(
            testTag = "upcoming_expense",
            useUnmergedTree = true
        ).assertTextEquals("$amount $currency")
    }

    fun assertUpcomingDoesNotExist() {
        composeTestRule.onNodeWithTag(
            testTag = "upcoming_title",
            useUnmergedTree = true
        ).assertDoesNotExist()
    }

    fun clickClose() {
        composeTestRule.onNodeWithContentDescription("close")
            .performClick()
    }
}