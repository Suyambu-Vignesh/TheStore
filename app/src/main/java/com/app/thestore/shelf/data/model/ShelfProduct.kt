package com.app.thestore.shelf.data.model

import com.app.thestore.common.adapter.CollectionItem
import com.squareup.moshi.Json

data class ShelfProduct(
    @Json(name = "id") val id: Int?,
    @Json(name = "title") val title: String?,
    @Json(name = "price") val price: Double?,
    @Json(name = "description") val description: String?,
    @Json(name = "category") val category: String?,
    @Json(name = "image") val image: String?,
    @Json(name = "rating") val rating: Rating?,
    @Transient var itemCount: Int = 0,
    @Transient var availableItemCount: Int = 0
): CollectionItem
