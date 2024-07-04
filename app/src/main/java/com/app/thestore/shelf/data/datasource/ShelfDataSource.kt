package com.app.thestore.shelf.data.datasource

import com.app.thestore.shelf.data.model.ShelfProduct
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ShelfDataSource {
    @GET("products")
    suspend fun getProducts(): List<ShelfProduct>
}

internal fun getShelfDataSource(): ShelfDataSource {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://fakestoreapi.com")
        .build()
        .create(ShelfDataSource::class.java)
}
