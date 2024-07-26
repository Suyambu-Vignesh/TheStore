package com.app.thestore.cart

import androidx.fragment.app.Fragment
import com.app.thestore.core.principles.api.FeatureExternalApi
import com.app.thestore.shelf.data.model.ShelfProduct

interface CartExternalApi : FeatureExternalApi {
    /**
     * Method to return the starting point of cart Flow, Use this if needed to avoid the
     * nav graph
     *
     * @return [Fragment]
     */
    fun getCartFragment(): Fragment

    /**
     * Method to get the Number of distinguished Items Count
     *
     * @return Number of distinguished Items Count
     */
    fun getItemCount(): Int

    /**
     * Method to add an Item to the cart
     */
    fun addAnItem(shelfProduct: ShelfProduct)

    /**
     * Method to remove an Item to the cart if the item is present
     *
     * @return true if the item present and been removed or false
     */
    fun removeAnItem(shelfProduct: ShelfProduct): Boolean
}