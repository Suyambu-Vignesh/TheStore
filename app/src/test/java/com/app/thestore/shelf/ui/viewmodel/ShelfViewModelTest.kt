package com.app.thestore.shelf.ui.viewmodel

import com.app.thestore.shelf.data.repository.DefaultShelfRepository
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class ShelfViewModelTest {
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test shelf viewmodel initial state`() {
        val mockRepository = mockk<DefaultShelfRepository>()
        val viewModel =
            ShelfViewModel(
                mockRepository,
            )

        with(viewModel.pageState.value) {
            Truth.assertThat(this.isLoading).isTrue()
            Truth.assertThat(this.data).isNull()
        }
    }

    @Test
    fun `test shelf viewmodel fetch calls the respoistory datasource`() =
        runTest {
            val mockRepository = mockk<DefaultShelfRepository>()
            val viewModel =
                ShelfViewModel(
                    mockRepository,
                )

            coEvery { mockRepository.getProducts() } returns flow { }

            viewModel.fetchProduct()

            coVerify(exactly = 1) { mockRepository.getProducts() }
        }
}
