package com.app.thestore.cart

import com.app.thestore.cart.data.CartRepository
import com.app.thestore.core.api.FeaturePrivateApi
import com.app.thestore.shelf.data.model.ShelfProduct

interface CartPrivateApi : FeaturePrivateApi {

    /**
     * Helper fun to remove one count of an Item from cart
     */
    fun removeAnItemItem(product: ShelfProduct): Boolean

    /**
     * Helper fun to add one count of an Item from cart
     */
    fun addAnItem(product: ShelfProduct)

    /**
     * Helper fun to get the number of unique of Item in the cart
     */
    fun getUniqueItemCount(): Int

    /**
     * Helper fun to get the [CartRepository]
     */
    fun getCartRepository(): CartRepository

    override val TAG: String
        get() = "CartPrivateApi"
}