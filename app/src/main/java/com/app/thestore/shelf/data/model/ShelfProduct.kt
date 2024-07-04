package com.app.thestore.shelf.data.model

import com.squareup.moshi.Json

data class ShelfProduct(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "title") var title: String? = null,
    @Json(name = "price") var price: Double? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "category") var category: String? = null,
    @Json(name = "image") var image: String? = null,
    @Json(name = "rating") var rating: Rating? = Rating(),
)
