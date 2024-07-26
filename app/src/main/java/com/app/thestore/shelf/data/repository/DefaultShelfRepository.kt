package com.app.thestore.shelf.data.repository

import com.app.thestore.shelf.data.datasource.ShelfDataSource
import com.app.thestore.shelf.data.datasource.getShelfDataSource
import com.app.thestore.shelf.data.model.ShelfProduct
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DefaultShelfRepository(
    private val dataSource: ShelfDataSource = getShelfDataSource(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ShelfRepository {
    override suspend fun getProducts(): Flow<Result<List<ShelfProduct>>> {
        return flow {
            emit(dataSource.getProducts().toResult())
        }.catch { exe -> Result.failure<List<ShelfProduct>>(exe) }.flowOn(ioDispatcher)
    }
}

private fun List<ShelfProduct>.toResult(): Result<List<ShelfProduct>> {
    if (this.isEmpty()) {

    }
    return Result.success(this)
}
