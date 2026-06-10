package com.example.naxgym

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
// This is a test where it says that you clicked on the image
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickingDumbbellTriggersOnImageClick() {

        var clicked = false

        composeTestRule.setContent {
            HomeScreen(
                onImageClick = {
                    clicked = true
                    println("You clicked the image!")
                }
            )
        }

        composeTestRule
            .onNodeWithTag("dumbbellImage")
            .performClick()

        assertTrue(clicked)
    }
}