package com.example.composearticle

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.sp
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composearticle.ui.theme.ComposeArticleTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class ComposeArticleTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        val context = InstrumentationRegistry.getInstrumentation().context

        composeTestRule.setContent {
            ComposeArticleTheme {
                CompositionLocalProvider(LocalContext provides context) {
                    MainActivity()
                }
            }
        }

        composeTestRule.onNodeWithText(R.string.article_text_1.toString())
        composeTestRule.onNodeWithText(R.string.article_text_2.toString())
        composeTestRule.onNodeWithText(R.string.article_title.toString())


        composeTestRule.onRoot().printToLog("TAG")
    }


}
