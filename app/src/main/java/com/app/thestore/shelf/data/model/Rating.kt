package com.app.thestore.shelf.data.model

import com.squareup.moshi.Json

data class Rating(
    @Json(name = "rate") var rate: Double? = null,
    @Json(name = "count") var count: Int? = null,
)
