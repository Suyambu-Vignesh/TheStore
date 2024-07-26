package com.app.thestore.cart.api

import com.app.thestore.cart.CartPrivateApi
import com.app.thestore.cart.data.CartRepository
import com.app.thestore.shelf.data.model.ShelfProduct

class DefaultCartPrivateApi : CartPrivateApi {

    private val repository: CartRepository by lazy {

    }

    override fun removeAnItemItem(product: ShelfProduct): Boolean {
        return repository.removeAnItemItem(product)
    }

    override fun addAnItem(product: ShelfProduct) {
        repository.addAnItem(product)
    }

    override fun getUniqueItemCount(): Int {
        return repository.getUniqueItemCount()
    }

    override val TAG: String
        get() = "CartPrivateApi"
}