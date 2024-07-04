package com.app.thestore.shelf.data.repository

import com.app.thestore.shelf.data.datasource.ShelfDataSource
import com.app.thestore.shelf.data.datasource.getShelfDataSource
import com.app.thestore.shelf.data.model.ShelfProduct
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception

class DefaultShelfRepository(
    private val dataSource: ShelfDataSource = getShelfDataSource(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ShelfRepository {
    override suspend fun getProducts(): Flow<Result<List<ShelfProduct>>> {
        return flow {
            withContext(ioDispatcher) {
                try {
                    val result = dataSource.getProducts()
                    emit(Result.success(result))
                } catch (exe: Exception) {
                    emit(Result.failure(exe))
                }
            }
        }
    }
}
