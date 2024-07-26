package com.app.thestore.shelf.data.model

import com.squareup.moshi.Json

data class Rating(
    @Json(name = "rate") val rate: Double? = null,
    @Json(name = "count") val count: Int? = null,
)
