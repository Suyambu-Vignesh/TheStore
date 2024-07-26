package com.app.thestore.cart.data

import com.app.thestore.shelf.data.model.ShelfProduct
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartLocalDataSource(private val cartDao: CartDao): CartRepository<CartProduct> {

    override suspend fun removeAnItemItem(product: CartProduct): Boolean {
        val value = product.removeAnItem()

        withContext(Dispatchers.IO) {
            if (product.getItemCount() == 0) {
                cartDao.removeCartItem(product)
            } else {
                cartDao.updateCartItem(product)
            }
        }

        return value
    }

    override fun addAnItem(product: CartProduct) {
        TODO("Not yet implemented")
    }

    override fun getUniqueItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getAllUniqueItems(): List<CartProduct> {
        TODO("Not yet implemented")
    }
}