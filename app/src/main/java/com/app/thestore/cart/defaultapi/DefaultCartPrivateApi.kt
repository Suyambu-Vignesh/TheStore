package com.app.thestore.cart.defaultapi

import com.app.thestore.cart.CartPrivateApi
import com.app.thestore.cart.data.CartRepository
import com.app.thestore.cart.data.DefaultCartRepository
import com.app.thestore.shelf.data.model.ShelfProduct

class DefaultCartPrivateApi : CartPrivateApi {

    private val repository: CartRepository by lazy {
        DefaultCartRepository()
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

    override fun getCartRepository(): CartRepository {
        return repository
    }

    override val TAG: String
        get() = "CartPrivateApi"
}