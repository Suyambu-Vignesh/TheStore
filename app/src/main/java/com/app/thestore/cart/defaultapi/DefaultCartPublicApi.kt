package com.app.thestore.cart.defaultapi

import androidx.fragment.app.Fragment
import com.app.thestore.cart.CartPrivateApi
import com.app.thestore.cart.CartPublicApi
import com.app.thestore.cart.ui.CartFragment
import com.app.thestore.core.module.ApiProvider
import com.app.thestore.shelf.data.model.ShelfProduct

class DefaultCartPublicApi : CartPublicApi {
    override fun getCartFragment(): Fragment {
        return CartFragment()
    }

    override fun getItemCount(): Int {
        return ApiProvider.getFeatureApi(CartPrivateApi::class.java)?.getUniqueItemCount() ?: 0
    }

    override fun addAnItem(shelfProduct: ShelfProduct) {
        ApiProvider.getFeatureApi(CartPrivateApi::class.java)?.addAnItem(shelfProduct)
    }

    override fun removeAnItem(shelfProduct: ShelfProduct): Boolean {
        return ApiProvider.getFeatureApi(CartPrivateApi::class.java)?.removeAnItemItem(shelfProduct)
            ?: false
    }

    override val TAG: String
        get() = "DefaultCartPublicApi"
}