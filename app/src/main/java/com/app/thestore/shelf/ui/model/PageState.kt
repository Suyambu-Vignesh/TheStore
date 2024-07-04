package com.app.thestore.shelf.ui.model

import com.app.thestore.shelf.data.model.ShelfProduct

data class PageState(
    val isLoading: Boolean = true,
    val data: List<ShelfProduct>? = null,
    // todo error state
)
