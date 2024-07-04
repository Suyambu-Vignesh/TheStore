package com.app.thestore.shelf.data.repository

import com.app.thestore.shelf.data.model.ShelfProduct
import kotlinx.coroutines.flow.Flow

interface ShelfRepository {
    suspend fun getProducts(): Flow<Result<List<ShelfProduct>>>
}
