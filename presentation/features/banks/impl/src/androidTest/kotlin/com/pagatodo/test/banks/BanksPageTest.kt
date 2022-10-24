package com.pagatodo.test.banks

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.pagatodo.test.api.models.BankModel
import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.usecases.GetBanksUC
import com.pagatodo.test.banks.presentation.pages.BanksPage
import com.pagatodo.test.banks.presentation.viewmodel.BanksViewModel
import com.pagatodo.test.designsystem.theme.ApplicationTheme
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BanksPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @MockK
    lateinit var getBanksUC: GetBanksUC

    @MockK
    lateinit var onBackPressed: () -> Unit

    private lateinit var viewModel: BanksViewModel

    private val bank = BankModel(
        description = "description", bankName = "name", age = "1", url = ""
    )

    @Before
    fun init() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        coEvery { getBanksUC.invoke() } returns flow { emit(BanksUIStates.Success(listOf(bank))) }
        every { onBackPressed.invoke() } returns Unit
        viewModel = BanksViewModel(getBanksUC)
    }


    @Test
    fun bankPageShouldHaveTopAppBarTitle() {
        setView()
        composeTestRule
            .onNodeWithTag("app_bar_title")
            .assertExists()
    }

    @Test
    fun bankPageShouldHaveTopAppBarIcon() {
        setView()
        composeTestRule
            .onNodeWithTag("app_bar_icon", useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun bankPageShouldHaveTopAppBarIconIsClicked() {
        setView()
        composeTestRule
            .onNodeWithTag("app_bar_icon")
            .performClick()
        composeTestRule.waitForIdle()
        verify { onBackPressed.invoke() }
    }

    @Test
    fun bankPageShouldHaveAnyItemWithBank() {
        setView()
        composeTestRule.waitForIdle()
        composeTestRule
            .onAllNodesWithTag("default_image", useUnmergedTree = true)
            .onFirst()
            .assertExists()
    }

    private fun setView() {
        composeTestRule.setContent {
            ApplicationTheme {
                BanksPage(
                    viewModel = viewModel,
                    onBackPressed = onBackPressed
                )
            }
        }
    }
}
