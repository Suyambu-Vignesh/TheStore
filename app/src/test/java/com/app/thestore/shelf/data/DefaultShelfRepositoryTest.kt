package com.app.thestore.shelf.data

import com.app.thestore.shelf.data.datasource.ShelfDataSource
import com.app.thestore.shelf.data.repository.DefaultShelfRepository
import com.app.thestore.utils.flow.impl.test
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DefaultShelfRepositoryTest {
    @Test
    fun `test getProducts call ShelfDataSource`() =
        runTest {
            val dataSource = mockk<ShelfDataSource>()

            coEvery { dataSource.getProducts() } returns emptyList()
            val repository =
                DefaultShelfRepository(
                    dataSource,
                )
            repository.getProducts().collect {
            }
            coVerify(exactly = 1) { dataSource.getProducts() }
        }

    @Test
    fun `test getProduct success on data source empty result`() =
        runTest {
            val dataSource = mockk<ShelfDataSource>()
            coEvery { dataSource.getProducts() } returns emptyList()

            val repository =
                DefaultShelfRepository(
                    dataSource,
                )
            val flowObserver = repository.getProducts().test(this)
            advanceUntilIdle()
            flowObserver.assert { values ->
                Truth.assertThat(values.size).isEqualTo(1)
                Truth.assertThat(values[0].isSuccess).isTrue()
            }
        }

    @Test
    fun `test getProduct success on data source on result`() =
        runTest {
            val dataSource = mockk<ShelfDataSource>()
            coEvery { dataSource.getProducts() } returns listOf(mockk())

            val repository =
                DefaultShelfRepository(
                    dataSource,
                )
            val flowObserver = repository.getProducts().test(this)

            advanceUntilIdle()

            flowObserver.assert { values ->
                Truth.assertThat(values.size).isEqualTo(1)
                Truth.assertThat(values[0].isSuccess).isTrue()
            }
        }

    @Test
    fun `test getProduct success on data source Failure`() =
        runTest {
            val dataSource = mockk<ShelfDataSource>()
            coEvery { dataSource.getProducts() } throws RuntimeException("")

            val repository =
                DefaultShelfRepository(
                    dataSource,
                )
            val flowObserver = repository.getProducts().test(this)
            advanceUntilIdle()

            flowObserver.assert { values ->
                Truth.assertThat(values.size).isEqualTo(1)
                Truth.assertThat(values[0].isFailure).isTrue()
            }
        }
}
