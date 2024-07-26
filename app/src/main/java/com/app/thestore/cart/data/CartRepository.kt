package com.app.thestore.cart.data

import com.app.thestore.shelf.data.model.ShelfProduct

interface CartRepository<Product> {
    /**
     * Method which help to remove one count product from cart, If there only one quantity will just
     * remove the Item all together.If no item present then will do nothing
     *
     * @param product [ShelfProduct] to be removed
     *
     * @return true if the product is present in cart and removed one count from the cart
     */
    suspend fun removeAnItemItem(product: Product): Boolean

    /**
     * Method which help to add one count of product to cart.
     *
     * @param product [ShelfProduct] to be Added
     */
    suspend fun addAnItem(product: Product)

    /**
     * Method which get the number of unique Item in cart
     *
     * @return count as [Int]
     */
    suspend fun getUniqueItemCount(): Int

    /**
     * Method which get all the unique Items in cart
     *
     * @return list of [ShelfProduct]
     */
    suspend fun getAllUniqueItems(): List<Product>
}